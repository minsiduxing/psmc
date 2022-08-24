package priv.guochun.psmc.system.framework.activiti.core;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import priv.guochun.psmc.system.framework.activiti.service.PsmcBaseWorkFlowService;
import priv.guochun.psmc.system.framework.activiti.service.TFlowConfigService;
import priv.guochun.psmc.system.framework.activiti.service.TFlowInstanceService;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;

/**
 * 1、psmc工作流上下文实现类,主要作用是包装发布一些流程相关的基础公共操作
 * 2、对activiti的原生操作对象进行无侵入扩展, 使客户端使用工作流就像使用activiti本身一样
 *  * 3、所有使用工作流的客户端都必须从context获取操作对象 解耦客户端与activiti的关系
 *  * @author Administrator
 *
 */
public class PsmcWorkFlowContextImpl implements PsmcWorkFlowContext {

	/**
	 * 包装后的runtimeService
	 */
	private RuntimeService	runtimeService;

	/**
	 * 包装后的taskService
	 */
	private TaskService	taskService;

	private HistoryService historyService;
	private RepositoryService repositoryService;
	private PsmcCacheFactory psmcCacheFactory;

	private PsmcBaseWorkFlowService psmcBaseWorkFlowService;

	private TFlowInstanceService tFlowInstanceService;

	private TFlowConfigService tFlowConfigService;
	
	@Override
	public boolean enableEqualize(){
		return true;
	}
	
	@Override
	public boolean enableAudit(){
		return true;
	}


	@Override
	public Integer getRetryCount() {
		if(enableEqualize()){
			return new Integer(3);
		}else
			return new Integer(0);
		
	}

	public PsmcCacheFactory getPsmcCacheFactory() {
		return psmcCacheFactory;
	}

	public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory) {
		this.psmcCacheFactory = psmcCacheFactory;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
	@Override
	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	@Override
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public PsmcBaseWorkFlowService getPsmcBaseWorkFlowService() {
		return psmcBaseWorkFlowService;
	}

	public void setPsmcBaseWorkFlowService(PsmcBaseWorkFlowService psmcBaseWorkFlowService) {
		this.psmcBaseWorkFlowService = psmcBaseWorkFlowService;
	}

	public TFlowInstanceService gettFlowInstanceService() {
		return tFlowInstanceService;
	}

	public void settFlowInstanceService(TFlowInstanceService tFlowInstanceService) {
		this.tFlowInstanceService = tFlowInstanceService;
	}

	public TFlowConfigService gettFlowConfigService() {
		return tFlowConfigService;
	}

	public void settFlowConfigService(TFlowConfigService tFlowConfigService) {
		this.tFlowConfigService = tFlowConfigService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
}
