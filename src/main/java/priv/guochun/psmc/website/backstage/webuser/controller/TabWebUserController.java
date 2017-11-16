package priv.guochun.psmc.website.backstage.webuser.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.webuser.model.TabWebUser;
import priv.guochun.psmc.website.backstage.webuser.service.TabWebUserService;

@Scope("prototype")
@Controller
@RequestMapping("/website/backstage/webUserController")
public class TabWebUserController extends MyController {

	protected static final  Logger logger  = LoggerFactory.getLogger(TabWebUserController.class);
	
	@RequestMapping(params="method=login")  
	@ResponseBody
	public void login(HttpServletRequest request,HttpServletResponse response,TabWebUser webUser){
		try {
			Boolean flag = true;
			String msg = "登录成功！";
			String userId = webUser.getUserId();
			String password = webUser.getPassword();
			if(StringUtils.isBlank(userId) || StringUtils.isBlank(password)){
				flag = false;
				msg = "用户名和密码不能为空！";
			}else{
				int count = tabWebUserService.isVaild(userId, password);
				if(count == 0){
					flag = false;
					msg = "用户名和密码错误！";
				}
			}
			super.responseJson(flag, msg, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(params="method=webUserList")  
	@ResponseBody
	public void webUserList(HttpServletRequest request,
		 	HttpServletResponse response,MyPage mypage){
		try {
			mypage = tabWebUserService.getWebUserList(mypage);
			super.responseJson(JsonUtil.convertToJSONObject(mypage), response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 账号新增、修改入口
	 * @param request
	 * @param response
	 * @param uuid
	 * @param oper
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=initEdit") 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String initEdit(HttpServletRequest request,
		 	HttpServletResponse response,String uuid,String oper,ModelMap modelMap) throws IOException{
		Map user = null;
		if(StringUtils.isNotBlank(uuid)){
			
		}else{
			String userUuid = UUIDGenerator.createUUID();
			user = new HashMap<String, String>();
			user.put("UUID", userUuid);
		}
		modelMap.put("oper", oper);
		modelMap.put("user", user);
		return "backstage/webuser/user_edit";
	}
	
	@Autowired
	private TabWebUserService tabWebUserService;
}
