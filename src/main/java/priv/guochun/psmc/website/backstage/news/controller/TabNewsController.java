package priv.guochun.psmc.website.backstage.news.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.news.service.TabNewsService;
@Scope("prototype")
@Controller
@RequestMapping("/website/backstage/tabNewsController")
public class TabNewsController extends MyController {
	protected static final Logger logger = LoggerFactory.getLogger(TabNewsController.class);
	@Autowired
	private TabNewsService tabNewsService;
	@RequestMapping(params="method=index")
	public String index(){
		return "backstage/news/newslist";
	}
	@RequestMapping(params="method=getNesPage")
	@ResponseBody
	public void getNesPage(HttpServletRequest request,
		 	HttpServletResponse response,MyPage mypage) throws IOException{
		mypage = tabNewsService.getNewsByCondition(mypage);
		super.responseJson(JsonUtil.convertToJSONObject(mypage), response);
	}
	@RequestMapping(params="method=newsSaveOrUpdate")
	public String newsSaveOrUpdate(){
		return "backstage/news/newsaddoredit";
	}
	@RequestMapping(params="method=newsAudit")
	public String newsAudit(){
		return "backstage/news/newslist";
	}
}
