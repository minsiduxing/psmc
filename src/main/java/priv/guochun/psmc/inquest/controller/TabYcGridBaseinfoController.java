package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcGridBaseInfoService;
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
     * 办证测算功能
     * @param myPage
     * @throws IOException
     */
    public void handleCertCacl(MyPage myPage) throws IOException {
        //1、查询该网格下的测算类别，根据测算类别查询测算公示，展示店面特征供申请人选择

        //2、申请人选择店面特征后，后台根据选择的特征对应公式进行测算，返回测算结果
    }
}
