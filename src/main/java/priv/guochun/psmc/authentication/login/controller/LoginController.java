package priv.guochun.psmc.authentication.login.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.StringUtil;

import priv.guochun.psmc.authentication.auth.PsmcAuthentication;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.model.UserPassword;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;


@Scope("prototype")
@Controller
@RequestMapping("/authentication/loginController")
public class LoginController  extends MyController {
    
         protected static final  Logger logger  = LoggerFactory.getLogger(LoginController.class);
    	 
         @Autowired
    	 private LoginService loginService;
         
         @Autowired
         private TabAccountService tabAccountService;
	 
    	 @RequestMapping(params="method=entrance")  
    	 public String entrance(HttpServletRequest request,
    			 	HttpServletResponse response,ModelMap modelMap){
    		//获取服务器当前时间 add by yangqing 2017-6-21
        	Long serverTime=System.currentTimeMillis();
        	request.setAttribute("serverTime", serverTime);
    		return "/jindex";
    	 }
    	 
	 
	 /**
	     * 得到某个角色的导航栏信息
	     * @param request
	     * @param response
	     * @param roleUuid
	     * @throws IOException
	     */
	    @RequestMapping(params="method=getNavigationBarResources")  
	    @ResponseBody
	    public void getNavigationBarResources
	            (HttpServletRequest request,HttpServletResponse response,
	                    String roleUuid) throws IOException {
	        List<Map<?,?>> list = loginService.getNavigationBarResourcesByRoleUuid(roleUuid);
	        JSONObject returnJsonObj = JsonUtil.convertToJSONObject(list);
	        this.responseJson(returnJsonObj, response);
	    }
	    
	    /**
	     * 第一次点击导航栏初始化树信息
	     * @param request
	     * @param response
	     * @param roleUuid
	     * @param resourceId
	     * @throws IOException
	     */
	    @RequestMapping(params="method=initNavigationBarTree")  
	    @ResponseBody
	    public void initNavigationBarTree(HttpServletRequest request,HttpServletResponse response,
	            String roleUuid,String resourceId) throws IOException {    
	        Map<?, ?> map = loginService.getResource(resourceId, roleUuid);
	        this.responseJson(JsonUtil.convertToJSONObject(map), response);
	    }
	    
	    /**
	     * ajax动态获取树节点的下级子节点
	     * @param request
	     * @param response
	     * @param roleUuid
	     * @param resourceId
	     * @throws IOException
	     */
	    @RequestMapping(params="method=getSubResoruces")  
	    @ResponseBody
	    public void getSubResoruces(HttpServletRequest request,HttpServletResponse response,
	            String roleUuid,String resourceId) throws IOException {  
	        List<Map<?,?>> list = loginService.getSubResources(resourceId, roleUuid,false);
	        JSONArray returnJsonObj = JsonUtil.convertToJSONArray(list);
	        this.responseHtmltext(returnJsonObj.toString(), response);
	    }
	    
	    @RequestMapping(params="method=authenticationOperate")  
        @ResponseBody
        public void authenticationOperate(HttpServletRequest request,HttpServletResponse response,
                String operateNo) throws IOException {  
	        User user = this.getUserBySeesion(request);
            boolean isAuth = PsmcAuthentication.authentication(user.getRoleUuid(), operateNo);
            this.responseJson(isAuth, null, response);
	    }
	    
	    /**
	     * 用户修改密码操作
	     * @param request
	     * @param response
	     * @throws IOException
	     * @author youngqing 2017-4-8
	     * 在这里规定返回值对应信息内容{0：修改成功}，{1：旧密码错误，修改失败}，{2：新密码输入不一致，修改失败}
	     */
	    @RequestMapping(params="method=autUpdatePasswdOperate", method=RequestMethod.POST)
	    @ResponseBody
	    public String autUpdatePasswdOperate(UserPassword userPassword)throws IOException{
	    	String msg = null;
	    	User user = this.getUserBySeesion(this.request());
	    	String accountName = user.getAccountName();
	    	String oldPassword = userPassword.getOldPassword();
	    	String newPassword = userPassword.getNewPassword();
	    	String renewPassword = userPassword.getRenewPassword();
	    	Map userMap = tabAccountService.getTabAccount(accountName, oldPassword);
	    	/*User user = this.getUserBySeesion(request);
	    	String accountName = user.getAccountName();
	    	String oldPassword = request.getParameter("oldPassword");
	    	String newPassword = request.getParameter("newPassword");
	    	String renewPassword = request.getParameter("renewPassword");
	    	Map userMap = tabAccountService.getTabAccount(accountName, oldPassword);
	    	*/
	    	boolean is_True = false;
	    	if(null != userMap){
	    		//判断两次输入的新密码是否合法并一致
	    		if(StringUtil.isEmpty(newPassword) || StringUtil.isEmpty(renewPassword) || !newPassword.equals(renewPassword)){
	    			msg = "2";
	    		}else{
	    			//判断旧密码是不是正确
	    			TabAccount tabAccount = new TabAccount();
		    		tabAccount.setUuid(String.valueOf(user.getTabAccount().get("UUID")));
		    		tabAccount.setAccountName(accountName);
		    		tabAccount.setAccountPass(newPassword);
		    		is_True = tabAccountService.updateAccountPasswdMethod(tabAccount);
	    		}
	    	}
	    	if(is_True){
	    		msg = "0";
	    	}else{
	    		msg = "1";
	    	}
	    	return msg;
	    }
	    
}
