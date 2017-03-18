package priv.guochun.psmc.authentication.resource.controller;

import java.io.IOException;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.resource.model.TabResource;
import priv.guochun.psmc.authentication.resource.service.TabResourceService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;

@Scope("prototype")
@Controller
@RequestMapping("/authentication/tabResource")
public class TabResourceController  extends MyController
{    
    
    protected static final  Logger logger  = LoggerFactory.getLogger(TabResourceController.class);

    @Autowired
    private TabResourceService tabResourceService;
    
   
    
    /**
     * 进入可以编辑当前角色 所拥有的资源树的界面
     * <p>Description:<p>
     * @param request
     * @param response
     * @param roleUuid
     * @param resourceId
     * @throws IOException
     * @author guochun 2016-12-16
     */
    @RequestMapping(params="method=initEditResourceConfig")  
    @ResponseBody
    public void initEditResourceConfig(HttpServletRequest request,HttpServletResponse response,
            String roleUuid) throws IOException {  
        List<Map<?,?>> list = tabResourceService.getSystemAllResourcesBelongRole(roleUuid);
        JSONArray returnJsonObj = JsonUtil.convertToJSONArray(list);
        logger.debug("initEditResourceConfig : "+returnJsonObj.toString());
        this.responseHtmltext(returnJsonObj.toString(), response);
    }
    
    /**
     * 持久化某角色关联的资源信息
     * <p>Description:<p>
     * @param request
     * @param response
     * @param roleUuid
     * @throws IOException
     * @author guochun 2016-12-20
     */
    @RequestMapping(params="method=editResourceConfig")  
    @ResponseBody
    public void editResourceConfig(HttpServletRequest request,HttpServletResponse response,
            String roleUuid,String resourceIds) throws IOException {  
        boolean result =  tabResourceService.saveOrUpateResourceRoleRelationBusinessMethod(resourceIds, roleUuid);
        this.responseJson(result, null, response);
    }
    
    
    /**
     * 获取某个角色所拥有的资源树
     * <p>Description:<p>
     * @param request
     * @param response
     * @param roleUuid
     * @throws IOException
     * @author guochun 2017-2-15
     */
    @RequestMapping(params="method=getResourceTreeByRoleUuid")  
    @ResponseBody
    public void getResourceTreeByRoleUuid(HttpServletRequest request,HttpServletResponse response,
            String roleUuid) throws IOException {  
        List<Map<?,?>> list = tabResourceService.getResourcesBelongRole(roleUuid);
        JSONArray returnJsonObj = JsonUtil.convertToJSONArray(list);
        logger.debug("initEditResourceConfig : "+returnJsonObj.toString());
        this.responseHtmltext(returnJsonObj.toString(), response);
    }
    
    /**
     * 得到某个角色下、某个资源的 可操作的业务集合
     * <p>Description:<p>
     * @param request
     * @param response
     * @param roleUuid
     * @param resourceUuid
     * @throws IOException
     * @author guochun 2017-2-16
     */
    @RequestMapping(params="method=getPrivilegDataListByRoleAndResource")  
    @ResponseBody
    public void getPrivilegDataListByRoleAndResource(HttpServletRequest request,HttpServletResponse response,
            String roleUuid,String resourceUuid) throws IOException {  
        List<Map<?,?>> list = tabResourceService.getPrivilegDataListByRoleAndResource(roleUuid,resourceUuid);
        JSONArray returnJsonObj = JsonUtil.convertToJSONArray(list);
        this.responseHtmltext(returnJsonObj.toString(), response);
    }
    
    /**
     * 持久化某一个角色下的某一个资源下，分配给该角色多少"操作"（业务权限) 
     * @param request
     * @param response
     * @param roleUuid 角色id
     * @param resourceUuid 资源id
     * @param operate_uuids 操作uuid集合
     * @throws IOException
     */
    @RequestMapping(params="method=editRoleResourceOperateRelations")  
    @ResponseBody
    public void editRoleResourceOperateRelations(HttpServletRequest request,HttpServletResponse response,
            String roleUuid,String resourceUuid,String operate_uuids) throws IOException {  
        boolean result =  tabResourceService.saveRoleResourceOperateRelationsBusinessMethod(roleUuid,resourceUuid,operate_uuids);
        super.responseJson(result, null, response);
    }
    
    
    /**
     * 得到系统全部资源菜单的集合
     * <p>Description:<p>
     * @param request
     * @param response
     * @param roleUuid
     * @throws IOException
     * @author guochun 2017-2-23
     */
    @RequestMapping(params="method=getSysResouceTreeData")  
    @ResponseBody
    public void getSysResouceTreeData(HttpServletRequest request,HttpServletResponse response,
            String roleUuid) throws IOException {  
        @SuppressWarnings("unchecked")
        List<Map<?,?>> list = tabResourceService.getSystemAllResourcesBusinessMethod();
        JSONArray returnJsonObj = JsonUtil.convertToJSONArray(list);
        logger.debug("getSysResouceTreeData : "+returnJsonObj.toString());
        this.responseHtmltext(returnJsonObj.toString(), response);
    }
    
    @RequestMapping(params="method=ajaxAddResource")  
    @ResponseBody
    public void ajaxAddResource(HttpServletRequest request,HttpServletResponse response,TabResource tabResource) throws IOException{
        User user = super.getUserBySeesion(request);
        String result  =this.tabResourceService.saveOrUpdateTabResourceBusinessMethod(tabResource,user);
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("id", result);
        this.responseJson(JsonUtil.convertToJSONObject(resultMap), response);
    }
    
    @RequestMapping(params="method=ajaxDeleteResource")  
    @ResponseBody
    public void ajaxDeleteResource(HttpServletRequest request,HttpServletResponse response,String resourceUuid) throws IOException{
        JSONObject returnObj  =this.tabResourceService.deleteTabResourceBusinessMethod(resourceUuid);
        this.responseJson(returnObj, response);
    }
    
    /**
     * 仅仅是修改当前节点的
     * @param request
     * @param response
     * @param resourceUuid
     * @throws IOException
     */
    @RequestMapping(params="method=ajaxUpdateResourceTheParentUuid")  
    @ResponseBody
    public void ajaxUpdateResourceTheParentUuid(HttpServletRequest request,HttpServletResponse response,
    		String resourceUuid,String parentResourceUuid) throws IOException{
        boolean result  =this.tabResourceService.updateResourceTheParentUuidBusinessMethod(resourceUuid,parentResourceUuid);
        this.responseJson(result, null, response);
    }
    
    
    @RequestMapping(params="method=ajaxUpdateResourceTheName")  
    @ResponseBody
    public void ajaxUpdateResourceTheName(HttpServletRequest request,HttpServletResponse response,
    		String resourceUuid,String newName) throws IOException{
    	JSONObject returnObj  =this.tabResourceService.updateResourceTheNameBusinessMethod(resourceUuid,newName);
    	this.responseJson(returnObj, response);
    	
    }
    
}
