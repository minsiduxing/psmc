package priv.guochun.psmc.website.stage.bhkn.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.website.stage.bhkn.service.GenerateStageHtmlService;
@Scope("prototype")
@Controller
@RequestMapping("/website/stage/bhkn/generateStageHtmlController")
public class GenerateStageHtmlController extends MyController {

	
	@Autowired
	private GenerateStageHtmlService generateStageHtmlService;
	
	/**生成头部页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateHeadHtml")
	@ResponseBody
	public void generateHeadHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateHeadHtml();
		super.responseJson(true,"生成头部页面成功！", response);
	}
	/**生成页脚页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateFooterHtml")
	@ResponseBody
	public void generateFooterHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateFooterHtml();
		super.responseJson(true,"生成页脚页面成功！", response);
	}
	
	/**生成团队展示页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateTeamShowHtml")
	@ResponseBody
	public void generateTeamShowHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateTeamShowHtml();
		super.responseJson(true,"生成团队展示页面成功！", response);
	}
	
	/**生成选择我们页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateChooseUsHtml")
	@ResponseBody
	public void generateChooseUsHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateChooseUsHtml();
		super.responseJson(true,"生成选择我们页面成功！", response);
	}
	
	/**生成关于我们页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateAboutUsHtml")
	@ResponseBody
	public void generateAboutUsHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateAboutUsHtml();
		super.responseJson(true,"生成关于我们页面成功！", response);
	}
	/**生成产品一览页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateProductlistHtml")
	@ResponseBody
	public void generateProductlistHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateProductlistHtml();
		super.responseJson(true,"生成产品一览页面成功！", response);
	}
	/**生成产品一览页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=generateIndexHtml")
	@ResponseBody
	public void generateIndexHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateIndexHtml();
		super.responseJson(true,"生成产品一览页面成功！", response);
	}
	
	/**
	 * <p>Description:生成新闻列表页的html<p>
	 * @author wanglei 2017年9月21日
	 * @throws IOException 
	 */
	@RequestMapping(params="method=generateInfoHtml")
	@ResponseBody
	public void generateInfoHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateInofHtml();
		super.responseJson(true,"生成新闻列表页面成功！", response);
	}
	/**
	 * <p>Description:生成会员信息列表页的html<p>
	 * @author wanglei 2017年9月21日
	 * @throws IOException 
	 */
	@RequestMapping(params="method=generateMemberHtml")
	@ResponseBody
	public void generateMemberHtml(HttpServletResponse response) throws IOException{
		generateStageHtmlService.generateMemberInofHtml();
		super.responseJson(true,"生成会员列表页面成功！", response);
	}
	
	/**生成博汇康宁全部网站页面
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=genetateAllStageHtmls")
	@ResponseBody
	public void genetateAllStageHtmls(HttpServletResponse response) throws IOException{
		generateStageHtmlService.genetateAllStageHtmls();
		super.responseJson(true,"生成博汇康宁全部网站页面成功！", response);
	}
}
