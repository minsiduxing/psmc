package priv.guochun.psmc.website.backstage.questionnaire.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectConfig;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabQuestionnaireService;

@Controller
@RequestMapping("/website/backstage/QuestionnaireController")
public class QuestionnaireController extends MyController{

	private TabQuestionnaireService tabQuestionnaireService;
	
	/**
	 * 查询问卷题目列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=subjectConfigList")
	@ResponseBody
	public ModelAndView subjectConfigList(String questionnaireUuid) throws IOException{
		List<TabSubjectConfig> list = tabQuestionnaireService.querySubjectConfigListBusinessMethod(questionnaireUuid);
		String jsonStr = JSON.toJSONString(list);
		ModelAndView mv = new ModelAndView("backstage/questionnaire/questionnaireInvestigation");
		mv.addObject("list", list);
		return mv;
//		super.responseJson(JSON.parseArray(jsonStr), this.response());
	}
}
