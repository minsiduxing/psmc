package priv.guochun.psmc.inquest.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcRegionCoordinateService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inquest/tabYcRegionCoordinateController")
public class TabYcRegionCoordinateController extends MyController {

    @Autowired
    private TabYcRegionCoordinateService tabYcRegionCoordinateService;

    /**
     * 查询分页列表
     * @param page
     * @throws Exception
     */
    @RequestMapping(params="method=selectRegionCoordinatePage")
    @ResponseBody
    public void selectRegionCoordinatePage(MyPage page) throws Exception{
        String orgCode = this.getUserBySeesion(this.request()).getGroupCode();
        Map<String, Object> queryParams = page.getQueryParams();
        if (queryParams == null || queryParams.get("orgCode") == null){
            queryParams = new HashMap<>();
            queryParams.put("orgCode", orgCode);
            page.setQueryParams(queryParams);
        }
        page = tabYcRegionCoordinateService.selectRegionCoordinatePage(page);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(page), this.response());
    }

    /**
     * 跳转到坐标维护列表界面
     * @return
     */
    @RequestMapping(params="method=regionCoordinateList")
    public String regionCoordinateList(){
        return "inquest/regionCoordinateList";
    }

    /**
     * 分单位查询所有的区域坐标
     * @throws IOException
     */
    @RequestMapping(params="method=queryAllregionCoordinate")
    @ResponseBody
    public void queryAllregionCoordinate(String onlyOrgCode) throws IOException {
        Map<String, Object> queryParams = new HashMap<String, Object>();
        if(onlyOrgCode == null)
            onlyOrgCode = this.getUserBySeesion(this.request()).getGroupCode();
        queryParams.put("onlyOrgCode", onlyOrgCode);
        List list = tabYcRegionCoordinateService.queryAllRegionCoordinateInfo(queryParams);
        super.responseJson(JsonUtil.convertListObjToJSONArray(list), this.response());
    }
}
