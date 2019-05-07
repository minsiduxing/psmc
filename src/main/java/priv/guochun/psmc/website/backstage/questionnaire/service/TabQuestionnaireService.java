package priv.guochun.psmc.website.backstage.questionnaire.service;

import java.util.List;

import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;

public interface TabQuestionnaireService {

	/**
	 * 根据问卷ID查询问卷列表
	 * @param questionnaireUuid
	 * @return
	 */
	public List<TabSubjectConfig> querySubjectConfigListBusinessMethod(String questionnaireUuid);
}
