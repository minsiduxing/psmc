package priv.guochun.psmc.system.framework.activiti.core;

import java.util.List;

import org.activiti.engine.RuntimeService;

import org.activiti.engine.TaskService;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;

/**
 * psmc工作流上下文
 * @author Administrator
 */
public interface PsmcWorkFlowContext {
	
	
	public boolean enableEqualize();
	
	public boolean enableAudit();
	
	public RuntimeService getRuntimeService();
	
	//获取重试次数
	public Integer getRetryCount();
	
	/**
	 * 得到启用的流程表单配置信息
	 */
	public List<TFlowConfig> getWorkFlowDefinition();
	/**
	 * 根据表单编码获取启用的 最新的表单配置信息
	 * @param formno
	 * @return
	 */
	public TFlowConfig getWorkFlowDefinition(String formno);

	public TaskService getTaskService();
}
