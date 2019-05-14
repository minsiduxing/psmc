package priv.guochun.psmc.website.backstage.questionnaire.service;

import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;

public interface TabRealUrlService {

	public String insertRealUrl(TabRealUrl realUrl);
	
	public TabRealUrl queryRealUrlById(String id);
}
