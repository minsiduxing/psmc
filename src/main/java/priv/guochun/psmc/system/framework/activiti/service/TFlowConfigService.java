package priv.guochun.psmc.system.framework.activiti.service;

import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfigExample;

import java.util.List;

/**
 * 自定义的工作流配置表
 */
public interface TFlowConfigService {

	/**
	 * 根据条件获取TFlowConfig记录
	 * @param example
	 * @return
	 */
	public List<TFlowConfig> getAllTFlowConfig(TFlowConfigExample example);

	//从缓存获得配置
	public List<TFlowConfig> getWorkFlowDefinition();

	//从缓存获得配置
	public TFlowConfig getWorkFlowDefinition(String flowEnName);

	public void update(TFlowConfig tFlowConfig);
}
