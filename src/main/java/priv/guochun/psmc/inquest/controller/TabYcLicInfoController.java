package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcLicInfoService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;

@Controller
@RequestMapping("/inquest/tabYcLicInfoController")
public class TabYcLicInfoController extends MyController {

    @Autowired
    private TabYcLicInfoService tabYcLicInfoService;

    /**
     * 查询许可证数据分页
     * @param page
     * @throws Exception
     */
    @RequestMapping(params="method=selectLicInfoPage")
    @ResponseBody
    public void selectLicInfoPage(MyPage page) throws Exception{
        page = tabYcLicInfoService.selectLicInfoPage(page);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(page), this.response());
    }

    /**
     * 跳转到许可证维护列表界面
     * @return
     */
    @RequestMapping(params="method=licInfoList")
    public String licInfoList(){
        return "inquest/licInfoList";
    }
}
