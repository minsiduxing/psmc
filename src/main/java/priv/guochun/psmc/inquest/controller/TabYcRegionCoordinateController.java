package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcRegionCoordinateService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

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
}
