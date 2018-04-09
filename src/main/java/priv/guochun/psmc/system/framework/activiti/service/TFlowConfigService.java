package priv.guochun.psmc.system.framework.activiti.service;

import java.util.List;

import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfigExample;

public interface TFlowConfigService {

	/**
	 * 根据条件获取TFlowConfig记录
	 * @param example
	 * @return
	 */
	public List<TFlowConfig> getAllTFlowConfig(TFlowConfigExample example);
}
