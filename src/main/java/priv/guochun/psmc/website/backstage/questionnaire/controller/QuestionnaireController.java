package priv.guochun.psmc.website.backstage.questionnaire.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectResult;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabQuestionnaireService;
import priv.guochun.psmc.website.backstage.questionnaire.vo.TabSubjectResultVo;

@Controller
@RequestMapping("/website/backstage/QuestionnaireController")
public class QuestionnaireController extends MyController{

	@Autowired
	private TabQuestionnaireService tabQuestionnaireService;
	
	/**
	 * 查询问卷题目列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=subjectConfigList")
	@ResponseBody
	public ModelAndView subjectConfigList(String questionnaireUuid, String evaluateInfoUuid) throws IOException{
		List<TabSubjectConfig> list = tabQuestionnaireService.querySubjectConfigList(questionnaireUuid);
		Map<String, Object> map = tabQuestionnaireService.selectSubjectTypeNums(questionnaireUuid);
		ModelAndView mv = new ModelAndView("backstage/questionnaire/questionnaireInvestigation");
		mv.addObject("list", list);
		mv.addObject("type1", map.get("type1"));
		mv.addObject("type2", map.get("type2"));
		mv.addObject("type3", map.get("type3"));
		mv.addObject("type4", map.get("type4"));
		mv.addObject("type5", map.get("type5"));
		mv.addObject("type6", map.get("type6"));
		mv.addObject("questionnaireUuid", questionnaireUuid);
		mv.addObject("evaluateInfoUuid", evaluateInfoUuid);
		return mv;
	}
	
	
	/**
	 * 提交问卷
	 * @param resultVo
	 * @throws IOException
	 */
	@RequestMapping(params="method=submitQuestionnaire")
	public void submitQuestionnaire(TabSubjectResultVo resultVo) throws IOException{
		List<TabSubjectResult> resultList = resultVo.getResultList();
		tabQuestionnaireService.submitQuestion(resultList);
		super.responseJson(true, "提交成功!", this.response());
	}
	
	/**
	 * 查看用户评价详情
	 * @param questionnaireUuid
	 * @param evaluateInfoUuid
	 * @return
	 */
	@RequestMapping(params="method=queryResultDetails")
	public ModelAndView queryResultDetails(String questionnaireUuid, String evaluateInfoUuid){
		List<Map<String, Object>> list = tabQuestionnaireService.querySubjectResultDetails(evaluateInfoUuid, questionnaireUuid);
		ModelAndView mv = new ModelAndView("backstage/questionnaire/subjectResultDetails");
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 加载问卷信息
	 * @throws IOException
	 */
	@RequestMapping(params="method=loadQuestionnaire")
	@ResponseBody
	public void loadQuestionnaire() throws IOException{
		List<Map<?,?>> questList = tabQuestionnaireService.loadQuestionnaire();
		JSONArray ja = JsonUtil.convertToJSONArray(questList);
        super.responseJson(ja, this.response());
	}
}
