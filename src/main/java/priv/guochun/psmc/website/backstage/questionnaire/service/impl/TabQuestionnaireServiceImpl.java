package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabQuestionnaireService;

public class TabQuestionnaireServiceImpl implements TabQuestionnaireService{

	private static final String selectConflist = "selectConflist";
	private static final String loadQuestionnaire = "loadQuestionnaire";
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<TabSubjectConfig> querySubjectConfigList(String questionnaireUuid) {
		TabSubjectConfig subjectConfig = new TabSubjectConfig();
		subjectConfig.setQuestionnaireUuid(questionnaireUuid);
		return baseDao.queryForList(selectConflist, subjectConfig);
	}

	@Override
	public List<Map<?, ?>> loadQuestionnaire() {
		List<Map<?, ?>> list = baseDao.queryForList(loadQuestionnaire);
		return list;
	}
	
	
}
