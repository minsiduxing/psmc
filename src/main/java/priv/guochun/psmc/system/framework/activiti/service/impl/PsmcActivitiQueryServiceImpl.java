package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.List;

import org.activiti.engine.task.TaskQuery;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.service.PsmcActivitiQueryService;
import priv.guochun.psmc.system.framework.page.MyPage;

public class PsmcActivitiQueryServiceImpl implements PsmcActivitiQueryService {

	private PsmcWorkFlowContext psmcWorkFlowContext;
	
	@Override
	public List<?> getWaitTask(User user,MyPage page) {
//		TaskQuery tq = psmcWorkFlowContext.getTaskService().createTaskQuery();
//		long count = tq.psmcWorkFlowContext(user.getRoleNo()).count();
//		List<?> list = tq.list();
//		page.setTotalData((int)count);
//		return list;
		return null;
	}

	public PsmcWorkFlowContext getPsmcWorkFlowContext() {
		return psmcWorkFlowContext;
	}

	public void setPsmcWorkFlowContext(PsmcWorkFlowContext psmcWorkFlowContext) {
		this.psmcWorkFlowContext = psmcWorkFlowContext;
	}

	
	
	
}
