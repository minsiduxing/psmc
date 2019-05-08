package priv.guochun.psmc.website.backstage.questionnaire.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabQuestionnaireService;

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
	public ModelAndView subjectConfigList(String questionnaireUuid) throws IOException{
		List<TabSubjectConfig> list = tabQuestionnaireService.querySubjectConfigList(questionnaireUuid);
		String jsonStr = JSON.toJSONString(list);
		ModelAndView mv = new ModelAndView("backstage/questionnaire/questionnaireInvestigation");
		mv.addObject("list", list);
		return mv;
//		super.responseJson(JSON.parseArray(jsonStr), this.response());
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
