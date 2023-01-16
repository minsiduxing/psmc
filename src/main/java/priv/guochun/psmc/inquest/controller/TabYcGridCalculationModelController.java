package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.guochun.psmc.inquest.service.TabYcGridBaseInfoService;
import priv.guochun.psmc.inquest.service.TabYcGridCalculationModelService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JetlUtil;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 网格测算类型管理
 */
@Controller
@RequestMapping("/inquest/tabYcGridCalculationModelController")
public class TabYcGridCalculationModelController extends MyController {

    @Autowired
    private TabYcGridCalculationModelService tabYcGridCalculationModelService;
    @Autowired
    private TabYcGridBaseInfoService tabYcGridBaseInfoService;

    @RequestMapping(params="method=selectGridCalculationModelInfoList")
    @ResponseBody
    public void selectGridCalculationModelInfoList(MyPage myPage,String version) throws IOException {
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
        myPage = tabYcGridCalculationModelService.selectGridCalculationModelInfoList(myPage);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(myPage), this.response());
    }

    /**
     * 根据模型对应的测算类别加载所有的类别计算公式
     */
    @RequestMapping(params="method=selectGridCalculationModelInfoListBymodelTypeUuid")
    @ResponseBody
    public void selectGridCalculationModelInfoListBymodelTypeUuid(String modelTypeUuid) throws IOException {
        super.responseJson(tabYcGridCalculationModelService.queryGridCalculationModelBygridModelTypeUuid(modelTypeUuid),this.response());
    }

    /**
     * 测算网格的某个公式（是否具备办证能力，是否还有余量的意思）
     * @param param
     * @throws IOException
     */
    @RequestMapping(params="method=gridCmodelHanleCertCacl")
    @ResponseBody
    public void gridCmodelHanleCertCacl(@RequestParam Map<String,Object> param) throws IOException {
        String gridCmodelUuid = param.get("gridCmodelUuid").toString();
        String gridUuid = param.get("gridUuid").toString();
        super.responseJson(tabYcGridCalculationModelService.gridHanleCertCacl(gridCmodelUuid,gridUuid,param),this.response());
    }
}

