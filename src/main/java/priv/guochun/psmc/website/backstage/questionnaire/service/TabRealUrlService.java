package priv.guochun.psmc.website.backstage.questionnaire.service;

import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;

public interface TabRealUrlService {

	public Integer insertRealUrl(TabRealUrl realUrl);
	
	public TabRealUrl queryRealUrlById(Integer id);
}
