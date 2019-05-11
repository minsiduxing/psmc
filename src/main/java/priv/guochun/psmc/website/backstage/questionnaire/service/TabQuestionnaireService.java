package priv.guochun.psmc.website.backstage.questionnaire.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectResult;

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
	
	/**
	 * 统计各个类型题目的数量
	 * @param questionnaireUuid
	 * @return
	 */
	public Map<String, Object> selectSubjectTypeNums(String questionnaireUuid);
	
	/**
	 * 问卷提交
	 * @param list
	 */
	public void submitQuestion(List<TabSubjectResult> list);
	
	/**
	 * 查看评价详情
	 * @param evaluateInfoUuid
	 * @param questionnaireUuid
	 * @return
	 */
	public List<Map<String, Object>> querySubjectResultDetails(String evaluateInfoUuid, String questionnaireUuid);
}
