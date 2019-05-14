package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabRealUrlService;

public class TabRealUrlServiceImpl implements TabRealUrlService{
	
	private static final String selectRealUrlById = "selectRealUrlById";
	private static final String insertRealUrl = "insertRealUrl";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public String insertRealUrl(TabRealUrl realUrl) {
		baseDao.insert(insertRealUrl, realUrl);
		return realUrl.getId();
	}

	@Override
	public TabRealUrl queryRealUrlById(String id) {
		return (TabRealUrl) baseDao.queryForObject(selectRealUrlById, id);
	}

}
