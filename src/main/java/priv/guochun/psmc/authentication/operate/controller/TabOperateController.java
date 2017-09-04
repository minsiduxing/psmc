package priv.guochun.psmc.authentication.operate.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.authentication.operate.model.TabOperate;
import priv.guochun.psmc.authentication.operate.service.TabOperateService;
import priv.guochun.psmc.authentication.privilege.service.TabPrivilegeService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;

@Scope("prototype")
@Controller
@RequestMapping("/authentication/tabOperate")
public class TabOperateController  extends MyController
{    
    
    protected static final  Logger logger  = LoggerFactory.getLogger(TabOperateController.class);

    @Autowired
    private TabOperateService tabOperateService;
    
    @Autowired
    private TabPrivilegeService tabPrivilegeService;
    
    /**
     * 
     * <p>Description:<p>
     * @param request
     * @param response
     * @param id
     * @param oper
     * @param modelMap
     * @return
     * @throws IOException
     * @author wenxiaoming 2017年8月7日
     */
    @RequestMapping(params = "method=operateConfigUI")
    @SuppressWarnings({"rawtypes", "unchecked" })
    public String operateConfigUI(HttpServletRequest request,
            HttpServletResponse response,String id,String oper,ModelMap modelMap) throws IOException{
        Integer ordernum = tabOperateService.getTabOperateOrderNum();
        //操作权限下拉框数据
        List privileges = tabPrivilegeService.queryTabPrivilegeForCombboox();
        JSONArray privilegeTypeJson = JsonUtil.convertToJSONArray(privileges);
        modelMap.put("resourceUuid", id);
        modelMap.put("ordernum", ordernum);
        modelMap.put("privilegeTypeJson", privilegeTypeJson);
        return "authentication/resource/resourceOperateConfig";
    }
    
    /**
     * 根据资源id查询对应所有业务配置
     * <p>Description:<p>
     * @param request
     * @param response
     * @param resourceUuid
     * @throws IOException
     * @author wenxiaoming 2017年9月2日
     */
    @RequestMapping(params = "method=operateList")
    @SuppressWarnings({"rawtypes", "unchecked" })
    public void operateList(HttpServletRequest request,HttpServletResponse response,String resourceUuid) throws IOException{
        //查询该资源的所有业务操作
        List operateList = tabOperateService.getTabOperatesByResourceUuid(resourceUuid);
        JSONArray operateJson = JsonUtil.convertToJSONArray(operateList);
        response.getWriter().write("{\"rows\":" + operateJson.toString() + "}");
    }
    
   /**
    * 保存或更新资源操作业务配置
    * <p>Description:<p>
    * @param request
    * @param response
    * @param tabOperate
    * @throws IOException
    * @author wenxiaoming 2017年9月2日
    */
    @RequestMapping(params="method=editOperateConfig")  
    @ResponseBody
    @SuppressWarnings({"unchecked", "rawtypes" })
    public void editOperateConfig(HttpServletRequest request,
            HttpServletResponse response,TabOperate tabOperate) throws IOException{
        tabOperateService.saveOrUpdateResOperateConfig(tabOperate);
        Integer ordernum = tabOperateService.getTabOperateOrderNum();
        Map resultMap = new HashMap();
        resultMap.put("resourceUuid", tabOperate.getResourceUuid());
        resultMap.put("ordernum", ordernum);
        super.responseJson(JsonUtil.convertToJSONObject(resultMap), response);
    }
    
    /**
     *根据操作表示查询对应配置角色的个数
     * <p>Description:<p>
     * @param request
     * @param response
     * @param operateUuid
     * @throws IOException
     * @author wenxiaoming 2017年9月3日
     */
    @RequestMapping(params="method=selectRoleCountByOperate")  
    @ResponseBody
    @SuppressWarnings({"unchecked", "rawtypes" })
    public void selectRoleCountByOperate(HttpServletRequest request,
            HttpServletResponse response,String operateUuid) throws IOException{
        int count = tabOperateService.selectRoleCountByOperate(operateUuid);
        Map resultMap = new HashMap();
        resultMap.put("count", count);
        super.responseJson(JsonUtil.convertToJSONObject(resultMap), response);
    }
    
    /**
     * 删除操作配置
     * <p>Description:<p>
     * @param request
     * @param response
     * @param operateUuid
     * @throws IOException
     * @author wenxiaoming 2017年9月3日
     */
    @RequestMapping(params="method=deleteOperate") 
    @ResponseBody
    @SuppressWarnings({"unchecked", "rawtypes" })
    public void deleteOperate(HttpServletRequest request,
            HttpServletResponse response,String operateUuid) throws IOException{
        int count = tabOperateService.deleteOperate(operateUuid);
        Integer ordernum = tabOperateService.getTabOperateOrderNum();
        Map resultMap = new HashMap();
        resultMap.put("ordernum", ordernum);
        resultMap.put("count", count);
        super.responseJson(JsonUtil.convertToJSONObject(resultMap), response);
    }
}
