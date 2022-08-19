package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.service.PsmcBaseWorkFlowService;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.common.BaseDao;

public class PsmcBaseWorkFlowServiceImpl implements PsmcBaseWorkFlowService {

	@Autowired
	private PsmcWorkFlowContext psmcWorkFlowContext;

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

	public void getCurrentNextUserTaskUser(String processDefId,String taskId){
		BpmnModel bpmnModel = psmcWorkFlowContext.getRepositoryService().getBpmnModel(processDefId);
		Process process = bpmnModel.getProcesses().get(0);
		//获取所有普通任务节点
		List<UserTask> UserTaskList = process.findFlowElementsOfType(UserTask.class);
		for(UserTask userTask:UserTaskList){
			//获取当前任务节点Id
			String id  = userTask.getId();
			if(id.equals(taskId)){
				processTaskoutgoingFlows(processDefId,UserTaskList,userTask);
			}
		}
	}

	//处理任务出口
	private void processTaskoutgoingFlows(String processDefId,List<UserTask> UserTaskLists,UserTask currentTask){
		//获取当前任务节点的所有出线信息
		List<SequenceFlow> outgoingFlows = currentTask.getOutgoingFlows();
		for(SequenceFlow outgoingFlow:outgoingFlows){
			//获取出线连接的目标节点
			FlowElement targetFlowElement = outgoingFlow.getTargetFlowElement();
			//获取到了下一个节点的Id
			String nextId = targetFlowElement.getId();
			String nextName = targetFlowElement.getId();
			//如果是网关的话，重新调用此方法找下一节点
			if("Exclusive Gateway".equals(nextName)){
				 getCurrentNextUserTaskUser(processDefId,nextId);
			}else{
				Boolean skipResult = processSkipExpression(outgoingFlow);
				if(skipResult){
					//再次遍历所有普通任务节点
					for(UserTask userTasks:UserTaskLists) {
						String flowId = userTasks.getId();
						if (flowId.equals(nextId)) {
							List<String>  candidateUsers = userTasks.getCandidateUsers();
							List<String> candidateGroups = userTasks.getCandidateGroups();
							System.out.println("下一个节点的候选人【candidateUsers】:"+ JSON.toJSON(candidateUsers));
							System.out.println("下一个节点的候选组或角色【candidateGroups】:"+JSON.toJSON(candidateGroups));
						}
					}
				}
			}
		}
	}
	//处理任务线条的判断条件，返回结果，如果没有判断条件，默认返回true
	private Boolean processSkipExpression(SequenceFlow sequenceFlow){
		Boolean skipResult = true;
		String skipExpression = sequenceFlow.getSkipExpression();
		if(StringUtils.isNotBlank(skipExpression)){
			Expression exp = new SpelExpressionParser().parseExpression(skipExpression);
			exp.setValue("chief_audit","1");
			skipResult = exp.getValue(Boolean.class);
		}
		return skipResult;
	}
}
