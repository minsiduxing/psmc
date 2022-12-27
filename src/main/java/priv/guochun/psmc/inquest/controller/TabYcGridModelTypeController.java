package priv.guochun.psmc.inquest.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcGridModelTypeService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网格测算类型管理
 */
@Controller
@RequestMapping("/inquest/tabYcGridModelTypeController")
public class TabYcGridModelTypeController extends MyController {

    @Autowired
    private TabYcGridModelTypeService tabYcGridModelTypeService;

    @RequestMapping(params="method=selectGridModelTypeInfoList")
    @ResponseBody
    public void selectGridModelTypeInfoList(MyPage myPage,String version) throws IOException {
        String orgCode = this.getUserBySeesion(this.request()).getGroupCode();
        Map<String, Object> queryParams = myPage.getQueryParams();
        if (queryParams == null){
            queryParams = new HashMap<>();
        }
        queryParams.put("orgCode", orgCode);
        if (version != null){
            queryParams.put("version", version);
        }
        myPage.setQueryParams(queryParams);
        myPage = tabYcGridModelTypeService.selectGridModelTypeInfoList(myPage);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(myPage), this.response());
    }

    @RequestMapping(params="method=loadGridModelTypeDictList")
    @ResponseBody
    public void loadGridModelTypeDictList(MyPage myPage,String version) throws IOException {
        String orgCode = this.getUserBySeesion(this.request()).getGroupCode();
        Map<String, Object> queryParams = myPage.getQueryParams();
        if (queryParams == null){
            queryParams = new HashMap<>();
        }
        queryParams.put("orgCode", orgCode);
        if (version != null){
            queryParams.put("version", version);
        }
        myPage.setQueryParams(queryParams);
        myPage.setTotalData(10000);
        List<Map<?,?>> list = tabYcGridModelTypeService.loadGridModelTypeDictList(myPage);
        JSONArray ja = JsonUtil.convertToJSONArray(list);
        super.responseJson(ja, this.response());
    }
}
