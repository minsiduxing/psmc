package priv.guochun.psmc.website.backstage.questionnaire.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;

public interface TabQuestionnaireService {

	/**
	 * 根据问卷ID查询问卷列表
	 * @param questionnaireUuid
	 * @return
	 */
	public List<TabSubjectConfig> querySubjectConfigList(String questionnaireUuid);
	
	/**
	 * 加载问卷信息，用于下拉列表
	 * @return
	 */
	public List<Map<?, ?>> loadQuestionnaire();
}
