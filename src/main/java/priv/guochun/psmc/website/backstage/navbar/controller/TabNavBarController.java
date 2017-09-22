package priv.guochun.psmc.website.backstage.navbar.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.website.stage.bhkn.service.GenerateStageHtmlService;
@Scope("prototype")
@Controller
@RequestMapping("/website/stage/navBarController")
public class TabNavBarController extends MyController {
	protected static final Logger logger = LoggerFactory.getLogger(TabNavBarController.class);
	@Autowired
	private GenerateStageHtmlService generateStageHtmlService;
	
	@RequestMapping(params="method=generateHeadHtml")
	@ResponseBody
	public void generateHeadHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateHeadHtml();
		super.responseJson(true,"生成头部模板成功！", response);
	}
	
}
