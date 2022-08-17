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
		/**
		 * SELECT b.NAME_ as startName,a.*
		 * FROM act_ru_task a,act_ru_variable b where a.PROC_INST_ID_=b.PROC_INST_ID_ and b.name_='startUserId'
		 */
		return null;
	}

	public PsmcWorkFlowContext getPsmcWorkFlowContext() {
		return psmcWorkFlowContext;
	}

	public void setPsmcWorkFlowContext(PsmcWorkFlowContext psmcWorkFlowContext) {
		this.psmcWorkFlowContext = psmcWorkFlowContext;
	}

	
	
	
}
