package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabQuestionnaireService;

public class TabQuestionnaireServiceImpl implements TabQuestionnaireService{

	private static final String selectConflist = "selectConflist";
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<TabSubjectConfig> querySubjectConfigListBusinessMethod(String questionnaireUuid) {
		TabSubjectConfig subjectConfig = new TabSubjectConfig();
		subjectConfig.setQuestionnaireUuid(questionnaireUuid);
		return baseDao.queryForList(selectConflist, subjectConfig);
	}
	
	
}
