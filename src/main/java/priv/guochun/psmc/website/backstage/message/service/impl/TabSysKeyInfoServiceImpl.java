package priv.guochun.psmc.website.backstage.message.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.message.model.TabSysKeyInfo;
import priv.guochun.psmc.website.backstage.message.service.TabSysKeyInfoService;

public class TabSysKeyInfoServiceImpl implements TabSysKeyInfoService {

	@Autowired
	private BaseDao baseDao;
	
	private static final String selectSysKeyInfoList = "selectSysKeyInfoList";
	
	@Override
	public List<TabSysKeyInfo> findSysKeyInfoList(String sysKey, String sysValue) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("sysKey", sysKey);
		condition.put("sysValue", sysValue);
		List<TabSysKeyInfo> list = baseDao.queryForList(selectSysKeyInfoList, condition);
		return list;
	}

}
