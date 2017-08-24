package priv.guochun.psmc.website.backstage.navbar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.enums.FreemarkEnum;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.util.FreemarkUtil;
import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;
import priv.guochun.psmc.website.backstage.navbar.service.TabNavBarService;
@Scope("prototype")
@Controller
@RequestMapping("/website/stage/navBarController")
public class TabNavBarController extends MyController {
	protected static final Logger logger = LoggerFactory.getLogger(TabNavBarController.class);
	@Autowired
	private TabNavBarService tabNavBarService;
	
	@RequestMapping(params="method=generateHeadHtml")
	@ResponseBody
	public void generateHeadHtml(HttpServletResponse response) throws IOException{
		String realPath = this.getRealPath();
		String outPath = realPath+"resources/";
		logger.info("------------------获取导航栏菜单数据----------------------");
		 List<TabNavBar>  navbars = tabNavBarService.getAllShowTabNavBar();
		logger.info("------------------获取导航栏菜单数据成功！----------------------");
		Map<String,Object> remaps= new HashMap<String,Object>();
		remaps.put("navbars", navbars);
		//设置ftl模板路径
		FreemarkUtil ftu = FreemarkUtil.getInstance(FreemarkEnum.FREEMARKER_VERSIONNO.getValue(),FreemarkEnum.FTL_PATH.getValue());
		logger.info("------------------正在生成网站head.html！-到"+outPath+"---------------------");
		ftu.fprintTemplate(remaps, "head.ftl", outPath, "head.html");
		logger.info("------------------生成网站head.html成功！----------------------");
		super.responseJson(true,"生成头部模板成功！", response);
	}
	
}
