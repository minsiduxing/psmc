package priv.guochun.psmc.system.common.sysConfig.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.system.common.sysConfig.model.TabSysConfig;
import priv.guochun.psmc.system.common.sysConfig.service.TabSysConfigService;
import priv.guochun.psmc.website.backstage.common.BaseDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabSysConfigServiceImpl implements TabSysConfigService{

	private static final String selectSysConfigList = "selectSysConfigList";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<TabSysConfig> findSysConfigList(String sysCode, String sysType){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("sysCode", sysCode);
		condition.put("sysType", sysType);
		List<TabSysConfig> list = baseDao.queryForList(selectSysConfigList, condition);
		return list;
	}
}
