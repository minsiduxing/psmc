package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

/**
 * @description 排队管理服务
 * @author wangt
 * @create 2022/12/28 16:09
 */
public interface TabYcQueueManageService {

    /**
     * 查询排队管理分页
     * @param page
     * @return
     */
    MyPage selectQueueManagePage(MyPage page);
}
