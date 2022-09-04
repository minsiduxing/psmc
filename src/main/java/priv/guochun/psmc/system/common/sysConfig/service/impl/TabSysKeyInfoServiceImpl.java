package priv.guochun.psmc.system.common.sysConfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.system.common.sysConfig.model.TabSysKeyInfo;
import priv.guochun.psmc.system.common.sysConfig.service.TabSysKeyInfoService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabSysKeyInfoServiceImpl implements TabSysKeyInfoService {


	private static final String selectSysKeyListInfo = "selectSysKeyListInfo";

	@Autowired
	private BaseDao baseDao;
	@Override
	public List<?> findSysKeyInfoList(String sysKey, String sysValue) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("sysKey", sysKey);
		condition.put("sysValue", sysValue);
		List<TabSysKeyInfo> list = baseDao.queryForList(selectSysKeyListInfo, condition);
		return list;
	}

	@Override
	public MyPage getSysKeyInfoList(MyPage page) {
		return baseDao.getMyPage(page,selectSysKeyListInfo,page.getQueryParams());
	}


}
