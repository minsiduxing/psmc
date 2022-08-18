package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
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
		condition.put("accountId",user.getAccountName());
		return baseDao.getMyPage(page, selectWaitReceiveTasks, condition);
	}

	@Override
	public MyPage selectWaitProcessTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("accountId",user.getAccountName());
		return baseDao.getMyPage(page, selectWaitProcessTasks, condition);
	}

	@Override
	public MyPage selectProcessedTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("accountId",user.getAccountName());
		return baseDao.getMyPage(page, selectProcessedTasks, condition);
	}

	@Override
	public MyPage selectStartedByMeTasks(User user, MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		condition.put("accountId",user.getAccountName());
		return baseDao.getMyPage(page, selectStartedByMeTasks, condition);
	}

	public MsgModel startFlow(Map<String, Object> variables){
		MsgModel mm = null;
		ProcessInstance pi = psmcWorkFlowContext.getRuntimeService().startProcessInstanceByKey(variables.get("formNo").toString(), variables);
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

}
