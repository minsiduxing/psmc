package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

/**
 * 网格管理
 */
public interface TabYcGridModelTypeService {


    /**
     * 分页查询网格数据
     * @param myPage
     * @return
     */
    MyPage selectGridModelTypeInfoList(MyPage myPage);

}
