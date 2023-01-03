package priv.guochun.psmc.inquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.service.TabYcQueueManageService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

@Controller
@RequestMapping("/inquest/tabYcQueueManageController")
public class TabYcQueueManageController extends MyController {

    @Autowired
    private TabYcQueueManageService tabYcQueueManageService;

    /**
     * 查询排队管理分页
     * @param page
     * @throws Exception
     */
    @RequestMapping(params="method=selectQueueManagePage")
    @ResponseBody
    public void selectQueueManagePage(MyPage page) throws Exception{
        page = tabYcQueueManageService.selectQueueManagePage(page);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(page), this.response());
    }

    /**
     * 跳转到排队管理列表界面
     * @return
     */
    @RequestMapping(params="method=queueManageList")
    public String queueManageList(){
        return "inquest/queueManageList";
    }
}
