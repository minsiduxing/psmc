package priv.guochun.psmc.system.common.sysConfig.service;

import priv.guochun.psmc.system.common.sysConfig.model.TabSysKeyInfo;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;

public interface TabSysKeyInfoService {
	
	/**
	 * 系统初始化获取全部系统配置
	 * @param sysKey
	 * @param sysValue
	 * @return
	 */
	public List<?> findSysKeyInfoList(String sysKey, String sysValue);

	/**
	 * 从数据库中得到分页的系统配置信息
	 * @param page
	 * @return
	 */
	public MyPage selectAllSysKeyInfosBusinessMethod(MyPage page);

	public List selectAllSysKeyInfos(String sysKey);
}
