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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;


@Scope("prototype")
@Controller
@RequestMapping("/authentication/loginController")
public class LoginController  extends MyController {
    
    protected static final  Logger logger  = LoggerFactory.getLogger(LoginController.class);
	 @Autowired
	 private LoginService loginService;
	 
	 @RequestMapping(params="method=entrance")  
	 public String entrance(HttpServletRequest request,
			 	HttpServletResponse response,ModelMap modelMap){
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
	        logger.debug("加载导航栏数据: "+returnJsonObj.toString());
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
	 
}
