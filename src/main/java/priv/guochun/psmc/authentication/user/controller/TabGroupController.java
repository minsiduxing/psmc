package priv.guochun.psmc.authentication.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.user.model.TabGroup;
import priv.guochun.psmc.authentication.user.service.TabGroupService;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;


@Scope("prototype")
@Controller
@RequestMapping("/authentication/tabGroupController")
public class TabGroupController extends MyController {

	protected static final  Logger logger  = LoggerFactory.getLogger(TabGroupController.class);
	
	@Autowired
	private TabGroupService tabGroupService;
	
	@RequestMapping(params="method=initTabGroup")  
	@ResponseBody
	public void initTabGroup(HttpServletRequest request,HttpServletResponse response) throws IOException {  
        List<Map<?,?>> list = tabGroupService.getTabGroupsBusinessMethod();
        JSONArray returnJsonObj = JsonUtil.convertToJSONArray(list);
        this.responseHtmltext(returnJsonObj.toString(), response);
    }
	
	/**
	 * 修改组的归属组(拖拽）
	 * @param request
	 * @param response
	 * @param groupCode
	 * @param parentGroupCode
	 * @throws IOException
	 */
	@RequestMapping(params="method=ajaxUpdateGroupTheParentGroupCode")  
	@ResponseBody
	public void ajaxUpdateGroupTheParentGroupCode(HttpServletRequest request,HttpServletResponse response,String groupCode,String parentGroupCode) throws IOException {  
		MsgModel msgmodel =tabGroupService.updateParentGroupCodeBusinessMethod(groupCode,parentGroupCode);
        String returnStr = GsonUtil.toJsonForObject(msgmodel);
        this.responseHtmltext(returnStr, response);
    }
	
	/**
	 * 新增 编辑页面进入
	 * @param request
	 * @param response
	 * @param oper
	 * @throws IOException 
	 */
	@RequestMapping(params="method=initEdit")  
	public String initEdit(HttpServletRequest request,HttpServletResponse response,
			String oper,String groupCode,String parentGroupCode,ModelMap modelMap) throws IOException{
		TabGroup tabGroup = null;
		if("edit".equals(oper)){
			tabGroup = tabGroupService.getTabGroupsByGroupCode(groupCode);
		}else {
			tabGroup = new TabGroup();
			tabGroup.setUuid(UUIDGenerator.createUUID());
			tabGroup.setParentGroupCode(parentGroupCode);
			
		}
		
		modelMap.put("oper", oper);
        modelMap.put("tabGroup", tabGroup);
        return "authentication/user/tab_group_edit";
	}
	
	@RequestMapping(params="method=saveOrUpdateGroup")  
	@ResponseBody
	public void saveOrUpdateGroup(HttpServletRequest request,HttpServletResponse response,TabGroup tabGroup,String oper) throws IOException {
		MsgModel msgmodel = null;
		if("save".endsWith(oper)){
			HttpSession seesion = request.getSession();
            User user = (User)seesion.getAttribute("user");
            String accountName = user.getAccountName();//获取当前登录人账号
            tabGroup.setCreatorName(accountName);
            tabGroup.setCreateTime(new Date());
            tabGroup.setOrdernum((long)tabGroupService.getTabGroupCount()+1);
            msgmodel =tabGroupService.saveTabGroupBusinessMethod(tabGroup);
		}
			
		else
			msgmodel =tabGroupService.updateTabGroupBusinessMethod(tabGroup);
		String returnStr = GsonUtil.toJsonForObject(msgmodel);
        this.responseHtmltext(returnStr, response);
    }
	
	
	@RequestMapping(params="method=delGroup")  
	@ResponseBody
	public void delGroup(HttpServletRequest request,HttpServletResponse response,TabGroup tabGroup) throws IOException {
		MsgModel msgmodel = tabGroupService.deleteTabGroupBusinessMethod(tabGroup);
		String returnStr = GsonUtil.toJsonForObject(msgmodel);
        this.responseHtmltext(returnStr, response);
    }
	
	@RequestMapping(params="method=getTreeJson")  
	@ResponseBody
	public void getTreeJson(HttpServletRequest request,HttpServletResponse response,String id) throws IOException{
		String tree = null;
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> cacheMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String default_groupid =cacheMap.get("default_groupid").toString();
		if(StringUtils.isEmpty(id)){
			//默认获取组织机构根根节点
			TabGroup tg = tabGroupService.getTabGroupsByGroupCode(default_groupid);
			tree="[{\"id\": "+tg.getGroupCode()+", \"text\": \""+tg.getGroupName()+"\",\"state\": \"closed\",\"children\": null  }] ";
		}else{
			List<TabGroup> list = tabGroupService.getSubTabGroupsByGroupCode(id);
			if(list != null && list.size()>0){
				StringBuffer sb1 = new StringBuffer();
				sb1.append("[");
				for(int i=0;i<list.size();i++) {
					TabGroup tg = list.get(i);
					sb1.append("{\"id\": "+tg.getGroupCode()+", \"text\": \""+tg.getGroupName()+"\",\"state\": \"closed\",\"children\": null  } ");
					if(i<list.size()-1)
						sb1.append(",");
				}
				sb1.append("]");
				tree =sb1.toString();
			}
		}
			
		
		this.responseJson(tree, response);
	}
	
	

	public TabGroupService getTabGroupService() {
		return tabGroupService;
	}

	public void setTabGroupService(TabGroupService tabGroupService) {
		this.tabGroupService = tabGroupService;
	}
	
	
}
