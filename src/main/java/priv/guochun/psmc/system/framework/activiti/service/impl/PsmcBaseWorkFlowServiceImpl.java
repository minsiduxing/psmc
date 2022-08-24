package priv.guochun.psmc.system.framework.activiti.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.core.image.CustomProcessDiagramGenerator;
import priv.guochun.psmc.system.framework.activiti.service.PsmcBaseWorkFlowService;
import priv.guochun.psmc.system.framework.activiti.util.FlowContans;
import priv.guochun.psmc.system.framework.activiti.util.FlowElContans;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.MyStringUtil;
import priv.guochun.psmc.website.backstage.common.BaseDao;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PsmcBaseWorkFlowServiceImpl implements PsmcBaseWorkFlowService {

	protected static final Logger logger  = LoggerFactory.getLogger(PsmcBaseWorkFlowServiceImpl.class);
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
		ProcessInstance pi = psmcWorkFlowContext.getRuntimeService().startProcessInstanceByKey(variables.get(FlowContans.FLOW_COMMON_VARIABLES_FLOW_EN_NAME).toString(), variables);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return MsgModel.buildDefaultSuccess(gson.toJson(pi));
	}

	public MsgModel completeTask(String taskId,Map<String, Object> variables,Map<String, Object> transientVariables){
		MsgModel mm = null;
		psmcWorkFlowContext.getTaskService().complete(taskId,variables,transientVariables);
		return MsgModel.buildDefaultSuccess();
	}

	public MsgModel claimTask(String taskId, String userId){
		if(StringUtils.isBlank(taskId) || StringUtils.isBlank(userId))
			throw new RuntimeException("任务号、用户id不能为空!");
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
				targetTask = recursionProcess(currTaskId,taskLists,outgoingFlows,myPage.getQueryParams());
			}
		}
		return getTaskUsers(targetTask,myPage);
	}

	//递归获取下一任务节点的UserTask对象
	private UserTask recursionProcess(String currTaskId,List<UserTask> taskLists,List<SequenceFlow> outgoingFlows,Map<String, Object> variables){
		UserTask nextTargetTask = null;
		for(SequenceFlow outgoingFlow:outgoingFlows){
			//获取出线连接的目标节点
			FlowElement targetFlowElement = outgoingFlow.getTargetFlowElement();
			//获取到了下一个节点的Id
			String nextId = targetFlowElement.getId();
			String nextName = targetFlowElement.getName();

			if(Gateway.class.isInstance(targetFlowElement)){
				Gateway gateway = (Gateway)targetFlowElement;
				//递归调用
				return recursionProcess(gateway.getId(),taskLists,gateway.getOutgoingFlows(),variables);
			}
			if(UserTask.class.isInstance(targetFlowElement)){
				boolean skipResult = false;
				List<SequenceFlow> inFlows = ((UserTask) targetFlowElement).getIncomingFlows();
				for(SequenceFlow inFlow:inFlows) {
					FlowElement sourceFlowElement = inFlow.getSourceFlowElement();
					if (sourceFlowElement.getId().equals(currTaskId)) {
						if (StringUtils.isNotBlank(inFlow.getConditionExpression())) {
							skipResult = FlowElContans.isConditionOfBool(inFlow.getConditionExpression(), variables);
						} else
							skipResult = true;
					}
					if (skipResult) break;
				}
				if(skipResult){
					//再次遍历所有普通任务节点
					for(UserTask userTasks:taskLists) {
						String flowId = userTasks.getId();
						if (flowId.equals(nextId)) {
							nextTargetTask = userTasks;
						}
					}
				}
			}
			if(nextTargetTask !=null)break;
		}
		return nextTargetTask;
	}

	//获取当前任务的候选处理人（支持角色、组查询，目前暂不支持合并，只能二选一，不支持流程任务直接指派人assignee的选择）
	private MyPage getTaskUsers(UserTask task,MyPage myPage){
		List<Map> flowChooseUsers = new ArrayList<Map>();
		List<String> candidateUsers = task.getCandidateUsers();

		if(candidateUsers != null && candidateUsers.size()>0){
			StringBuffer accountNames = new StringBuffer();
			for(String candidateUser:candidateUsers){
				accountNames.append(FlowElContans.isConditionOfString(candidateUser,myPage.getQueryParams()));
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and a.ACCOUNT_NAME in").append(MyStringUtil.StringFormatMethod(accountNames.toString()));
			Map<String, Object> queryParams = myPage.getQueryParams();
			queryParams.put("accountNames",sb.toString());
			myPage.setQueryParams(queryParams);
			return this.tabAccountService.getTabAccounts(myPage);
		}

		List<String> candidateGroups = task.getCandidateGroups();
		StringBuffer flowRoleOrGroupIds = new StringBuffer();
		if(candidateGroups != null && candidateGroups.size()>0){
			for(String candidateGroup:candidateGroups){
				flowRoleOrGroupIds.append(FlowElContans.isConditionOfString(candidateGroup,myPage.getQueryParams()));
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and ( ");
			sb.append("  g.role_no IN ").append(MyStringUtil.StringFormatMethod(flowRoleOrGroupIds.toString()));
			sb.append(" or d.group_code IN ").append(MyStringUtil.StringFormatMethod(flowRoleOrGroupIds.toString()));
			sb.append(")");
			Map<String, Object> queryParams = myPage.getQueryParams();
			queryParams.put("flowRoleOrGroupIds",sb.toString());
			myPage.setQueryParams(queryParams);
			return this.tabAccountService.getTabAccounts(myPage);
		}
		if(StringUtils.isNotBlank(task.getAssignee())){
			throw new RuntimeException("流程不支持assignee配置人员方式!");
		}
		return myPage;
	}


	/**
	 * 根据流程实例获取流程图片
	 * @param procInstId
	 */
	public  byte[]  getFlowImgByInstanceId(String procInstId) {
		InputStream imageStream = null;
		try {
			// 通过流程实例ID获取历史流程实例
			HistoricProcessInstance historicProcessInstance = psmcWorkFlowContext.getHistoryService()
					.createHistoricProcessInstanceQuery().processInstanceId(procInstId).singleResult();

			// 通过流程实例ID获取流程中已经执行的节点，按照执行先后顺序排序
			List<HistoricActivityInstance> historicActivityInstanceList = psmcWorkFlowContext.getHistoryService()
					.createHistoricActivityInstanceQuery()
					.processInstanceId(procInstId)
					.orderByHistoricActivityInstanceId()
					.asc()
					.list();

			// 将已经执行的节点放入高亮显示节点集合
			List<String> highLightedActivityIdList = historicActivityInstanceList.stream()
					.map(HistoricActivityInstance::getActivityId)
					.collect(Collectors.toList());

			// 通过流程实例ID获取流程中正在执行的节点
			List<Execution> runningActivityInstanceList = psmcWorkFlowContext.getRuntimeService().createExecutionQuery()
					.processInstanceId(procInstId)
					.list();

			List<String> runningActivityIdList = new ArrayList<>();
			for (Execution execution : runningActivityInstanceList) {
				if (!StringUtils.isEmpty(execution.getActivityId())) {
					runningActivityIdList.add(execution.getActivityId());
				}
			}

			// 定义流程画布生成器
			CustomProcessDiagramGenerator processDiagramGenerator = new CustomProcessDiagramGenerator();

			// 获取流程定义Model对象
			BpmnModel bpmnModel = psmcWorkFlowContext.getRepositoryService().getBpmnModel(historicProcessInstance.getProcessDefinitionId());

			// 获取已经流经的流程线，需要高亮显示流程已经发生流转的线id集合
//            List<String> highLightedFlowsIds = getHighLightedFlows(bpmnModel, historicActivityInstanceList);
			List<String> highLightedFlowsIds = getHighLightedFlowsByIncomingFlows(bpmnModel, historicActivityInstanceList);

			// 根据runningActivityIdList获取runningActivityFlowsIds
			List<String> runningActivityFlowsIds = getRunningActivityFlowsIds(bpmnModel, runningActivityIdList, historicActivityInstanceList);

			// 使用默认配置获得流程图表生成器，并生成追踪图片字符流
			imageStream = processDiagramGenerator.generateDiagramCustom(
					bpmnModel,
					highLightedActivityIdList, runningActivityIdList, highLightedFlowsIds, runningActivityFlowsIds,
					"宋体", "微软雅黑", "黑体");
			return IOUtils.toByteArray(imageStream);
		} catch (Exception e) {
			logger.error("通过流程实例ID【{}】获取流程图时出现异常！", e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("通过流程实例ID" + procInstId + "获取流程图时出现异常！");
		} finally {
			if (imageStream != null) {
				try{
					imageStream.close();
				}catch(Exception e){
					logger.error("io流关闭错误!!!"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}


	public List<String> getHighLightedFlowsByIncomingFlows(BpmnModel bpmnModel,
														   List<HistoricActivityInstance> historicActivityInstanceList) {
		//historicActivityInstanceList 是 流程中已经执行的历史活动实例
		// 已经流经的顺序流，需要高亮显示
		List<String> highFlows = new ArrayList<>();

		// 全部活动节点(包括正在执行的和未执行的)
		List<FlowNode> allHistoricActivityNodeList = new ArrayList<>();

		/*
		 * 循环的目的：
		 *           获取所有的历史节点FlowNode并放入allHistoricActivityNodeList
		 *           获取所有确定结束了的历史节点finishedActivityInstancesList
		 */
		for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
			// 获取流程节点
			// bpmnModel.getMainProcess()获取一个Process对象
			FlowNode flowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstance.getActivityId(), true);
			allHistoricActivityNodeList.add(flowNode);
		}
		// 循环活动节点
		for (FlowNode flowNode : allHistoricActivityNodeList) {
			// 获取每个活动节点的输入线
			List<SequenceFlow> incomingFlows = flowNode.getIncomingFlows();

			// 循环输入线，如果输入线的源头处于全部活动节点中，则将其包含在内
			for (SequenceFlow sequenceFlow : incomingFlows) {
				if (allHistoricActivityNodeList.stream().map(BaseElement::getId).collect(Collectors.toList()).contains(sequenceFlow.getSourceFlowElement().getId())){
					highFlows.add(sequenceFlow.getId());
				}
			}
		}
		return highFlows;
	}


	private List<String> getRunningActivityFlowsIds(BpmnModel bpmnModel, List<String> runningActivityIdList, List<HistoricActivityInstance> historicActivityInstanceList) {
		List<String> runningActivityFlowsIds = new ArrayList<>();
		List<String> runningActivityIds = new ArrayList<>(runningActivityIdList);
		// 逆序寻找，因为historicActivityInstanceList有序
		if (CollectionUtils.isEmpty(runningActivityIds)) {
			return runningActivityFlowsIds;
		}
		for (int i = historicActivityInstanceList.size() - 1; i >= 0; i--) {
			HistoricActivityInstance historicActivityInstance = historicActivityInstanceList.get(i);
			FlowNode flowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstance.getActivityId(), true);
			// 如果当前节点是未完成的节点
			if (runningActivityIds.contains(flowNode.getId())) {
				continue;
			}
			// 当前节点的所有流出线
			List<SequenceFlow> outgoingFlowList = flowNode.getOutgoingFlows();
			// 遍历所有的流出线
			for (SequenceFlow outgoingFlow : outgoingFlowList) {
				// 获取当前节点流程线对应的下一级节点
				FlowNode targetFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(outgoingFlow.getTargetRef(), true);
				// 如果找到流出线的目标是runningActivityIdList中的，那么添加后将其移除，避免找到重复的都指向runningActivityIdList的流出线
				if (runningActivityIds.contains(targetFlowNode.getId())) {
					runningActivityFlowsIds.add(outgoingFlow.getId());
					runningActivityIds.remove(targetFlowNode.getId());
				}
			}

		}
		return runningActivityFlowsIds;
	}

}
