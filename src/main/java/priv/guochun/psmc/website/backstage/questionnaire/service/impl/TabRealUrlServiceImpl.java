package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabRealUrlService;

public class TabRealUrlServiceImpl implements TabRealUrlService{
	
	private static final String selectRealUrlById = "selectRealUrlById";
	private static final String insertRealUrl = "insertRealUrl";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Integer insertRealUrl(TabRealUrl realUrl) {
		baseDao.insert(insertRealUrl, realUrl);
		return realUrl.getId();
	}

	@Override
	public TabRealUrl queryRealUrlById(Integer id) {
		return (TabRealUrl) baseDao.queryForObject(selectRealUrlById, id);
	}

}
