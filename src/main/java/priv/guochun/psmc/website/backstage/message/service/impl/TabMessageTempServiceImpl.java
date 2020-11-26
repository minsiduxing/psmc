package priv.guochun.psmc.website.backstage.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.message.model.TabMessageTemp;
import priv.guochun.psmc.website.backstage.message.service.TabMessageTempService;

public class TabMessageTempServiceImpl implements TabMessageTempService {

	private static final String selectByTempExample = "selectByTempExample";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public TabMessageTemp queryByTempCode(String tempCode) {
		TabMessageTemp messageTemp = new TabMessageTemp();
		messageTemp.setTempCode(tempCode);
		TabMessageTemp tmt =  (TabMessageTemp) baseDao.queryForObject(selectByTempExample,messageTemp);
		return tmt;
	}

	@Override
	public List<TabMessageTemp> queryByTempCodeList() {
		List<TabMessageTemp> templist = baseDao.queryForList(selectByTempExample);
		return templist;
	}

}
