package priv.guochun.psmc.system.framework.activiti.service;

import java.util.List;

import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfigExample;
import priv.guochun.psmc.system.framework.cache.CacheContants;

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
}
