package priv.guochun.psmc.system.common.sysConfig.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.common.sysConfig.service.TabSysConfigService;
import priv.guochun.psmc.system.common.sysConfig.service.TabSysKeyInfoService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;


@Controller
@RequestMapping("/system/common/sysKeyController")
public class SysKeyController extends MyController  {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(SysKeyController.class);
	
	 @Autowired
	 private TabSysKeyInfoService tabSysKeyInfoService;

	 @Autowired
	 private TabSysConfigService tabSysConfigService;


	@RequestMapping(params="method=selectAllSysKeyInfos")
	@ResponseBody
	public void selectAllSysKeyInfosBusinessMethod(MyPage page) throws IOException {
		page = tabSysKeyInfoService.selectAllSysKeyInfosBusinessMethod(page);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}

}
