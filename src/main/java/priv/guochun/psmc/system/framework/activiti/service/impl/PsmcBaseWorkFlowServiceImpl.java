package priv.guochun.psmc.system.framework.activiti.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.service.PsmcBaseWorkFlowService;
import priv.guochun.psmc.system.framework.activiti.util.FlowElContans;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.common.BaseDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PsmcBaseWorkFlowServiceImpl implements PsmcBaseWorkFlowService {

	@Autowired
	private PsmcWorkFlowContext psmcWorkFlowContext;
	@Autowired
	private TabAccountService tabAccountService;
	private final static String selectWaitReceiveTasks = "selectWaitReceiveTasks";
	private final static String selectWaitProcessTasks = "selectWaitProcessTasks";
	private final static String selectProcessedTasks = "selectProcessedTasks";
	private final static String selectStartedByMeTasks = "selectStartedByMeTasks";

	@Autowired
	private BaseDao baseDao;

	@Override
	public MyPage selectWaitReceiveTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("account_id",user.getAccountName());
		condition.put("role_id",user.getRoleNo());
		condition.put("group_id",user.getGroupCode());
		return baseDao.getMyPage(page, selectWaitReceiveTasks, condition);
	}

	@Override
	public MyPage selectWaitProcessTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("account_id",user.getAccountName());
		return baseDao.getMyPage(page, selectWaitProcessTasks, condition);
	}

	@Override
	public MyPage selectProcessedTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("account_id",user.getAccountName());
		return baseDao.getMyPage(page, selectProcessedTasks, condition);
	}

	@Override
	public MyPage selectStartedByMeTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("account_id",user.getAccountName());
		return baseDao.getMyPage(page, selectStartedByMeTasks, condition);
	}

	public MsgModel startFlow(Map<String, Object> variables){
		MsgModel mm = null;
		ProcessInstance pi = psmcWorkFlowContext.getRuntimeService().startProcessInstanceByKey(variables.get("flow_en_name").toString(), variables);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return MsgModel.buildDefaultSuccess(gson.toJson(pi));
	}

	public MsgModel completeTask(String taskId,Map<String, Object> variables){
		MsgModel mm = null;
		psmcWorkFlowContext.getTaskService().complete(taskId,variables);
		return MsgModel.buildDefaultSuccess();
	}

	public MsgModel claimTask(String taskId, String userId){
		MsgModel mm = null;
		psmcWorkFlowContext.getTaskService().claim(taskId,userId);
		return MsgModel.buildDefaultSuccess();
	}

	public MsgModel unClaimTask(String taskId){
		MsgModel mm = null;
		psmcWorkFlowContext.getTaskService().unclaim(taskId);
		return MsgModel.buildDefaultSuccess();
	}

	public MyPage getNextTaskUser(String tfiId, String currTaskId,MyPage myPage){
		ProcessInstance pi = psmcWorkFlowContext.getRuntimeService().createProcessInstanceQuery().processInstanceId(tfiId).singleResult();
		String pdefId = pi.getProcessDefinitionId();
		BpmnModel bpmnModel = psmcWorkFlowContext.getRepositoryService().getBpmnModel(pdefId);
		Process process = bpmnModel.getProcesses().get(0);
		//获取所有普通任务节点
		List<UserTask> taskLists = process.findFlowElementsOfType(UserTask.class);
		UserTask targetTask = null;
		for(UserTask userTask:taskLists){
			//获取当前任务节点Id
			String id  = userTask.getId();
			if(id.equals(currTaskId)){
				List<SequenceFlow> outgoingFlows = userTask.getOutgoingFlows();
				targetTask = recursionProcess(pdefId,taskLists,outgoingFlows,myPage.getQueryParams());
			}
		}
		return getTaskUsers(targetTask,myPage);
	}

	//递归获取下一任务节点的UserTask对象
	private UserTask recursionProcess(String pdefId,List<UserTask> taskLists,List<SequenceFlow> outgoingFlows,Map<String, Object> variables){
		UserTask nextTargetTask = null;
		for(SequenceFlow outgoingFlow:outgoingFlows){
			//获取出线连接的目标节点
			FlowElement targetFlowElement = outgoingFlow.getTargetFlowElement();
			//获取到了下一个节点的Id
			String nextId = targetFlowElement.getId();
			String nextName = targetFlowElement.getName();
			if(ExclusiveGateway.class.isInstance(targetFlowElement)){
				ExclusiveGateway gateway = (ExclusiveGateway)targetFlowElement;
				//递归调用
				return recursionProcess(pdefId,taskLists,gateway.getOutgoingFlows(),variables);
			}else{
				if(UserTask.class.isInstance(targetFlowElement)){
					boolean skipResult = true;
					List<SequenceFlow> inFlows = ((UserTask) targetFlowElement).getIncomingFlows();
					for(SequenceFlow inFlow:inFlows){
						if(StringUtils.isNotBlank(inFlow.getSkipExpression())){
							skipResult = FlowElContans.isConditionOfBool(inFlow.getSkipExpression(),variables);
							if(!skipResult) break;
						}
					}
					if(!skipResult) break;
					//再次遍历所有普通任务节点
					for(UserTask userTasks:taskLists) {
						String flowId = userTasks.getId();
						if (flowId.equals(nextId)) {
							nextTargetTask = userTasks;
						}
					}
				}
			}
		}
		return nextTargetTask;
	}


	private MyPage getTaskUsers(UserTask task,MyPage myPage){
		List<Map> flowChooseUsers = new ArrayList<Map>();
		List<String> candidateUsers = task.getCandidateUsers();
		if(candidateUsers != null && candidateUsers.size()>0){
			StringBuffer sb = new StringBuffer();
			for(String candidateUser:candidateUsers){
				sb.append(FlowElContans.isConditionOfString(candidateUser,myPage.getQueryParams())+",");
			}
			myPage.getQueryParams().put("accountNames",sb.substring(0,sb.lastIndexOf(",")));
			return tabAccountService.getTabAccounts(myPage);
		}

		List<String> candidateGroups = task.getCandidateGroups();
		if(candidateGroups != null && candidateGroups.size()>0){
			StringBuffer sb = new StringBuffer();
			for(String candidateGroup:candidateGroups){
				sb.append(FlowElContans.isConditionOfString(candidateGroup,myPage.getQueryParams())+",");
			}
			Map<String, Object> queryParams = myPage.getQueryParams();
			queryParams.put("flowRoleOrGroupIds",sb.substring(0,sb.lastIndexOf(",")));
			myPage.setQueryParams(queryParams);
			return this.tabAccountService.getTabAccounts(myPage);
		}
		return myPage;
	}
}
