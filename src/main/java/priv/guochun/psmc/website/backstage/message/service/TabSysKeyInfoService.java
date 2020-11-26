package priv.guochun.psmc.website.backstage.message.service;

import java.util.List;

import priv.guochun.psmc.website.backstage.message.model.TabSysKeyInfo;

public interface TabSysKeyInfoService {
	
	/**
	 * 查询系统配置信息列表
	 * @param sysKey
	 * @param sysValue
	 * @return
	 */
	public List<TabSysKeyInfo> findSysKeyInfoList(String sysKey, String sysValue);
}
