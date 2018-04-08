package priv.guochun.psmc.system.framework.activiti.core;

import java.util.List;

import org.activiti.engine.RuntimeService;

/**
 * psmc工作流上下文
 * @author Administrator
 */
public interface PsmcWorkFlowContext {
	
	public RuntimeService getRuntimeService();
	
	//获取API调用重试次数
	public Integer getRetryCount();
	
	/**
	 * 得到流程表单配置信息
	 */
	public List<?> getWorkFlowDefinition();
	
	
}
