package priv.guochun.psmc.system.common.sysConfig.service;

import java.util.List;

import priv.guochun.psmc.system.common.sysConfig.model.TabSysConfig;

public interface TabSysConfigService {

	/**
	 * 查询系统配置信息列表
	 * @param sysCode
	 * @param sysType
	 * @return
	 */
	public List<TabSysConfig> findSysConfigList(String sysCode, String sysType);
}
