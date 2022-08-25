package priv.guochun.psmc.system.framework.activiti.core;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import priv.guochun.psmc.system.framework.activiti.service.PsmcBaseWorkFlowService;
import priv.guochun.psmc.system.framework.activiti.service.TFlowConfigService;
import priv.guochun.psmc.system.framework.activiti.service.TFlowInstanceService;

/**
 * psmc工作流上下文，一切操作工作流的对象都从这个上下文获取，主要是隔离业务和activiti的关联
 * @author Administrator
 */
public interface PsmcWorkFlowContext {
	
	
	public boolean enableEqualize();
	
	public boolean enableAudit();

	//获取重试次数
	public Integer getRetryCount();

	//得到psmc包装的runtimeService
	public RuntimeService getRuntimeService();
	
	//得到psmc包装的taskService
	public TaskService getTaskService();

	public RepositoryService getRepositoryService();

	public HistoryService getHistoryService();

	//得到psmc基础流程操作服务（任务查询、任务办理）
	public PsmcBaseWorkFlowService getPsmcBaseWorkFlowService();

	//得到psmc自己的流程实例服务（实例表相关服务）
	public TFlowInstanceService gettFlowInstanceService();


	public TFlowConfigService gettFlowConfigService();

}
