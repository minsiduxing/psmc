package priv.guochun.psmc.system.common.log.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.common.log.service.TSysOperLogService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;


@Controller
@RequestMapping("/system/common/sysOperLogController")
public class SysOperLogController extends MyController  {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(SysOperLogController.class);
	
	 @Autowired
	 private TSysOperLogService tSysOperLogService;

	 
	@RequestMapping(params = "method=sysOperLogList")
	@ResponseBody
	public void sysOperLogList(HttpServletResponse response, MyPage mypage)
				throws IOException {
			mypage = tSysOperLogService.getMyPageOfTSysOperLog(mypage);
			super.responseJson(JsonUtil.convertToJSONObject(mypage), response);
	}


	public TSysOperLogService gettSysOperLogService() {
		return tSysOperLogService;
	}


	public void settSysOperLogService(TSysOperLogService tSysOperLogService) {
		this.tSysOperLogService = tSysOperLogService;
	}
	
	
}
