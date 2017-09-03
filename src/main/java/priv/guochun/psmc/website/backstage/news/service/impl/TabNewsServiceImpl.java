package priv.guochun.psmc.website.backstage.news.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.backstage.news.dao.TabNewsDao;
import priv.guochun.psmc.website.backstage.news.model.TabNews;
import priv.guochun.psmc.website.backstage.news.service.TabNewsService;

public class TabNewsServiceImpl implements TabNewsService {
	protected static final  Logger logger  = LoggerFactory.getLogger(TabNewsServiceImpl.class);
	@Autowired
	private TabModuleService tabModuleService;
	@Autowired
	private TabNewsDao tabNewsDao;
	@Override
	public void saveOrUpdateTabNews(TabNews tabNews, TabModule tam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTabNewsByUuids(String uuids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getNewsByNewsUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPage getNewsByCondition(MyPage myPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getNewsListByCondition(MyPage myPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getShowNewsTitlesListByTowLevelClassify(
			String towLevelClassify) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void auditNews() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseNews() {
		// TODO Auto-generated method stub
		
	}

}
