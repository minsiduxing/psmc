package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectResult;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabQuestionnaireService;

public class TabQuestionnaireServiceImpl implements TabQuestionnaireService{

	private static final String selectConflist = "selectConflist";
	private static final String loadQuestionnaire = "loadQuestionnaire";
	private static final String selectSubjectTypeNums = "selectSubjectTypeNums";
	private static final String insertResult = "insertResult";
	private static final String selectResultList = "selectResultList";
	private static final String selectResultDetails = "selectResultDetails";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabEvaluateInfoService tabEvaluateInfoService;

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
	
	@Override
	public Map<String, Object> selectSubjectTypeNums(String questionnaireUuid){
		return (Map<String, Object>) baseDao.queryForObject(selectSubjectTypeNums, questionnaireUuid);
	}
	
	@Override
	public void submitQuestion(List<TabSubjectResult> list){
		if(list != null && list.size() > 0){
			String evaluateInfoUuid = "";
			for (int i=0; i<list.size(); i ++) {
				TabSubjectResult tabSubjectResult = list.get(i);
				//判断是否已经做过评价
				if(i==0){
					evaluateInfoUuid = tabSubjectResult.getEvaluateInfoUuid();
					List<TabSubjectResult> resultList = baseDao.queryForList(selectResultList, tabSubjectResult);
					if(resultList != null && resultList.size() > 0){
						throw new PsmcBuisnessException("您已经做过评价！");
					}
				}
				tabSubjectResult.setResultUuid(UUIDGenerator.createUUID());
				baseDao.insert(insertResult, tabSubjectResult);
			}
			//获取用户消费信息，更新问卷评价时间
			TabEvaluateInfo evaluateInfo = tabEvaluateInfoService.selectById(evaluateInfoUuid);
			if(evaluateInfo != null){
				evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_2);
				evaluateInfo.setEvaluateTime(DateUtil.getCurrentTimstamp());
				tabEvaluateInfoService.updateEvaluate(evaluateInfo);
			}
		}
	}
	
	@Override
	public List<Map<String, Object>> querySubjectResultDetails(String evaluateInfoUuid, String questionnaireUuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("evaluateInfoUuid", evaluateInfoUuid);
		condition.put("questionnaireUuid", questionnaireUuid);
		return baseDao.queryForList(selectResultDetails, condition);
	}
}
