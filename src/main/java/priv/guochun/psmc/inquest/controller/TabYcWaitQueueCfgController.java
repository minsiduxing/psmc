package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcWaitQueueCfgService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;


@Controller
@RequestMapping("/inquest/tabYcWaitQueueCfgController")
public class TabYcWaitQueueCfgController extends MyController {

    @Autowired
    private TabYcWaitQueueCfgService tabYcWaitQueueCfgService;

    /**
     * 查询分页列表
     * @param page
     * @throws Exception
     */
    @RequestMapping(params="method=selectWaitQueueCfgPage")
    @ResponseBody
    public void selectWaitQueueCfgPage(MyPage page) throws Exception{
        page = tabYcWaitQueueCfgService.selectWaitQueueCfgPage(page);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(page), this.response());
    }
}
