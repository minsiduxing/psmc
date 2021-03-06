package priv.guochun.psmc.website.stage.bhkn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.enums.FreemarkEnum;
import priv.guochun.psmc.system.util.FreemarkUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.navbar.controller.TabNavBarController;
import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;
import priv.guochun.psmc.website.backstage.navbar.service.TabNavBarService;
import priv.guochun.psmc.website.backstage.news.service.TabNewsService;
import priv.guochun.psmc.website.enums.ModuleEnum;
import priv.guochun.psmc.website.stage.bhkn.service.GenerateStageHtmlService;

public class GnerateStageHtmlServiceImpl implements GenerateStageHtmlService {
	protected static final Logger logger = LoggerFactory.getLogger(TabNavBarController.class);
	@Autowired
	private TabNavBarService tabNavBarService;
	@Autowired
	private TabNewsService tabNewsService;
	@Override
	public void generateHeadHtml() {
		logger.debug("------------------获取导航栏菜单数据----------------------");
		 List<TabNavBar>  navbars = tabNavBarService.getAllShowTabNavBar();
		logger.debug("------------------获取导航栏菜单数据成功！----------------------");
		Map<String,Object> remaps= new HashMap<String,Object>();
		remaps.put("navbars", navbars);
		 gnerateHtml(remaps,"bukn/head.ftl",getClass().getClassLoader().getResource("/ftl/bukn").getPath(),"head.html");
	     //gnerateHtml(remaps,"bukn/head.ftl","head.html");
		 //genetateOtherStageHtmls();
	}

	@Override
	public void generateIndexHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		logger.debug("------------------获取导航栏菜单数据----------------------");
		 List<TabNavBar>  navbars = tabNavBarService.getAllShowTabNavBar();
		logger.debug("------------------获取导航栏菜单数据成功！----------------------");
		remaps.put("navbars", navbars);
		gnerateHtml(remaps,"bukn/index.ftl", "index.html");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void generateInofHtml() {
		Map<String,Object> newsTitles= new HashMap<String,Object>();
		//获取行热点新闻列表
		List hotNews = tabNewsService.getShowNewsTitlesPagerByTowLevelClassify(ModuleEnum.TOW_LEVEL_HOT_NEWS.getValue());
		newsTitles.put("hotNews", JsonUtil.convertToJSONArray(hotNews));
		//获取实时资讯列表
		List quotationNews =	tabNewsService.getShowNewsTitlesPagerByTowLevelClassify(ModuleEnum.TOW_LEVEL_QUOTATION_INFOMATION.getValue());
		newsTitles.put("quotationNews", JsonUtil.convertToJSONArray(quotationNews));
		//获取行业动向列表
		List latesTrendsNews= tabNewsService.getShowNewsTitlesPagerByTowLevelClassify(ModuleEnum.TOW_LEVEL_LATES_TRENDS.getValue());
		newsTitles.put("latesTrendsNews", JsonUtil.convertToJSONArray(latesTrendsNews));
		//合并模板
		gnerateHtml(newsTitles,"bukn/info.ftl", "info.html");
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void generateMemberInofHtml(){
		Map<String,Object> memberInfos= new HashMap<String,Object>();
		//获取行热点新闻列表
		List memberInfo = tabNewsService.getShowNewsTitlesPagerByTowLevelClassify(ModuleEnum.TOW_LEVEL_MEMBER_INFORMATION.getValue());
		memberInfos.put("memberInfos", JsonUtil.convertToJSONArray(memberInfo));
		//合并模板
		gnerateHtml(memberInfos,"bukn/member.ftl", "member.html");
	}  
	@Override
	public void generateProductlistHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		gnerateHtml(remaps,"bukn/productlist.ftl", "productlist.html");
	}

	@Override
	public void generateAboutUsHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		gnerateHtml(remaps,"bukn/aboutus.ftl", "aboutus.html");
	}

	@Override
	public void generateChooseUsHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		gnerateHtml(remaps,"bukn/chooseus.ftl", "chooseus.html");
	}

	@Override
	public void generateTeamShowHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		gnerateHtml(remaps,"bukn/teamshow.ftl", "teamshow.html");
	}

	@Override
	public void generateFooterHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		 List<TabNavBar>  navbars = tabNavBarService.getAllShowTabNavBar();
			logger.debug("------------------获取导航栏菜单数据成功！----------------------");
			remaps.put("navbars", navbars);
		gnerateHtml(remaps,"bukn/footer.ftl",getClass().getClassLoader().getResource("/ftl/bukn").getPath(), "footer.html");
		//gnerateHtml(remaps,"bukn/footer.ftl", "footer.html");
		//genetateOtherStageHtmls();
	}

	@Override
	public void genetateAllStageHtmls() {
		generateFooterHtml();
		generateHeadHtml();
		genetateOtherStageHtmls();
	}
	private void gnerateHtml(Map<String,Object> root,String ftlPath,String fileName){
	
		//设置ftl模板路径
		 FreemarkUtil ftu = FreemarkUtil.getInstance(FreemarkEnum.FREEMARKER_VERSIONNO.getValue(),FreemarkEnum.FTL_PATH.getValue());
		 String outPath = ftu.getOutPutPath();
		logger.debug("----------------正在生成网站"+fileName+"！到"+outPath+"---------------------");
		ftu.fprintTemplate(root, ftlPath, outPath, fileName);
		logger.debug("------------------生成网站"+fileName+"成功！----------------------");
	}
	private void gnerateHtml(Map<String,Object> root,String ftlPath,String outPath,String fileName){
		//生成头部和底部页面因为要动态包含所以要放到和模板同一路径
		//设置ftl模板路径
		 FreemarkUtil ftu = FreemarkUtil.getInstance(FreemarkEnum.FREEMARKER_VERSIONNO.getValue(),FreemarkEnum.FTL_PATH.getValue());
		logger.debug("----------------正在生成网站"+fileName+"！到"+outPath+"---------------------");
		ftu.fprintTemplate(root, ftlPath, outPath, fileName);
		logger.debug("------------------生成网站"+fileName+"成功！----------------------");
	}

	@Override
	public void genetateOtherStageHtmls() {
		this.generateTeamShowHtml();
		this.generateChooseUsHtml();
		this.generateMemberInofHtml();
		this.generateAboutUsHtml();
		this.generateProductlistHtml();
		this.generateIndexHtml();
		this.generateInofHtml();
		this.generatereCruitHtml();
	}

	@Override
	public void generatereCruitHtml() {
		Map<String,Object> remaps= new HashMap<String,Object>();
		gnerateHtml(remaps,"bukn/recruit.ftl", "recruit.html");
	}
}
