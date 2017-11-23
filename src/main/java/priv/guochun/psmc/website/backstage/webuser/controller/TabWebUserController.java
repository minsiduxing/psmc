package priv.guochun.psmc.website.backstage.webuser.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
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
import org.springframework.web.servlet.View;

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
				}else{
					msg = "登录成功！";
					Cookie cooks = new Cookie("userID", "LOGINSUCCESS_USER"+userId);
					request.getSession().setAttribute("cuurentUser", "LOGINSUCCESS_USER"+userId);
					cooks.setMaxAge(30*60);
					cooks.setPath("/");
					response.addCookie(cooks);
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
			TabWebUser twu = new TabWebUser();
			twu.setUuid(uuid);
			user = tabWebUserService.findUserByCondition(twu);
		}else{
			String userUuid = UUIDGenerator.createUUID();
			user = new HashMap<String, String>();
			user.put("uuid", userUuid);
		}
		modelMap.put("oper", oper);
		modelMap.put("user", user);
		return "backstage/webuser/user_edit";
	}
	@RequestMapping(params="method=webuserloginout")  
	@ResponseBody
	public void webuserloginout(HttpServletRequest request,HttpServletResponse response,TabWebUser webUser) throws IOException{
		//获取用户的cookie 移除当前用的cookie 退出登录成功
		String msg = "";
		 Cookie[] cookies = request.getCookies();
		 if(null!=cookies ){
			 //遍历cookies数组
			 for(Cookie cookie: cookies){
				 String cuurentUser = String.valueOf(request.getSession().getAttribute("cuurentUser"));
				 if(cookie.getValue().equals(cuurentUser)){
					 cookie.setMaxAge(0);
					 cookie.setPath("/");
					 response.addCookie(cookie);
					 msg = "退出登录成功!";
					 break;
				 }
				 msg = "退出登录成功!";
			 }
		 }else{
			 msg = "系统错误!";
			 logger.debug("未获取到cookie 退出登录失败!");
		 }
		 super.responseJson(true, msg, response);
	}
	@RequestMapping(params="method=findPass")  
	@ResponseBody
	public void findPass(HttpServletRequest request,HttpServletResponse response,TabWebUser twu,String isupdate) throws IOException{
		//找回密码，先判断用户名是否准确，然后再提示用户是否要重置到初始密码123456如果要重置则重置默认密码
		Map<String,String>  res = new HashMap<>();
		Map<String,Object> resuser = tabWebUserService.findUserByCondition(twu);
	    //先查找用户信息存在不存在
		 if(StringUtils.isBlank(isupdate)){
			 if(null!=resuser&& resuser.size()>0){
				 res.put("flag", "1");
				 res.put("msg", "确定要重置到初始化密码吗？");
			 }else{
				 res.put("flag", "2");
				 res.put("msg", "用户不存在");
			 } 
		 }else{
			 //用户确认后修改密码
			 tabWebUserService.updateUser(twu);
			 res.put("flag", "3");
			 res.put("msg", "密码重置成功,初始密码为:123456");
		 }
		 
		 super.responseJson(JsonUtil.convertToJSONObject(res), response);;
	}
	
	/**
	 * 修改或保存用户
	 * @param request
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping(params="method=edit")  
    @ResponseBody
    public void edit(HttpServletRequest request,
            HttpServletResponse response,TabWebUser user) throws IOException{
		boolean exits = tabWebUserService.executeWebUserUniqueValidate(user);
		if (!exits) {
			super.responseJson(exits, "账号名称在系统中已存在,不能重复录入", response);
		} else {
			boolean result = tabWebUserService.saveOrUpdateTabWebUser(user);
			super.responseJson(result, null, response);
		}
    }
	
	/**
	 * 批量删除用户
	 * @param request
	 * @param response
	 * @param uuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=delete")  
    @ResponseBody
    public void delete(HttpServletRequest request,
            HttpServletResponse response,String uuids) throws IOException{
		boolean result = tabWebUserService.deleteWebUsers(uuids);
		super.responseJson(result, null, response);
	}
	
	/**
	 * 用户列表导出
	 * @param request
	 * @param response
	 * @param mypage
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=exportUser")
	@SuppressWarnings("rawtypes")
	public View exportUser( HttpServletRequest request,HttpServletResponse response,MyPage mypage) throws IOException{
		//1、根据条件查询出列表账号
		mypage = tabWebUserService.getWebUserList(mypage);
		List userList = mypage.getDataList();
		//2、将得到的数据封装到excel里
		//2.1 设置属性列名
		 this.setColumns(new String[]{"USER_ID","USER_NAME","ID_CARD","PHONE"});
		//2.2 设置表格的显示名
		 this.setTitles(new String[]{"用户账号","用户姓名","身份证号","手机号码"});
		 //2.3设置文件名
		 this.setFileName("网站会员信息列表.xls");
		//2.4 初始化数据
		 this.setExportList(userList);
		//3、返回excel下载视图
		return this.responseExcelFile(response) ;
	}
	
	@Autowired
	private TabWebUserService tabWebUserService;
}
