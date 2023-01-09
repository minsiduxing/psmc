package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcGridBaseInfoService;
import priv.guochun.psmc.inquest.service.TabYcGridCalculationModelService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 网格管理
 */
@Controller
@RequestMapping("/inquest/tabYcGridBaseinfoController")
public class TabYcGridBaseinfoController extends MyController {

    @Autowired
    private TabYcGridBaseInfoService tabYcGridBaseInfoService;
    @Autowired
    private TabYcGridCalculationModelService tabYcGridCalculationModelService;

    @RequestMapping(params="method=selectGridInfoList")
    @ResponseBody
    public void selectGridInfoList(MyPage myPage) throws IOException {
        String orgCode = this.getUserBySeesion(this.request()).getGroupCode();
        Map<String, Object> queryParams = myPage.getQueryParams();
        if (queryParams == null){
            queryParams = new HashMap<>();
        }
        queryParams.put("orgCode", orgCode);
        myPage.setQueryParams(queryParams);
        myPage = tabYcGridBaseInfoService.queryGridInfoList(myPage);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(myPage), this.response());
    }

    /**
     * 测算网格下所有公式（是否具备办证能力，是否还有余量的意思）
     * @param gridUuid 网格uuid
     * @throws IOException
     */
    @RequestMapping(params="method=gridHanleCertCacl")
    @ResponseBody
    public void gridHanleCertCacl(String gridUuid) throws IOException {
        super.responseJson(tabYcGridCalculationModelService.gridHanleCertCacls(gridUuid),this.response());
    }


    /**
     * 修改网格对应的坐标
     * @param gridUuid
     * @param coordinate
     * @throws IOException
     */
    @RequestMapping(params="method=updateGirdCoordnate")
    @ResponseBody
    public void updateGirdCoordnate(String gridUuid,String coordinate,String isMaintainCoordinate) throws IOException {
        super.responseJson(tabYcGridBaseInfoService.updateGirdCoordnate(gridUuid,coordinate,isMaintainCoordinate),this.response());
    }
}
