package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

/**
 * 网格测算公式
 */
public interface TabYcGridCalculationModelService {


    /**
     * 分页查询网格数据
     * @param myPage
     * @return
     */
    MyPage selectGridCalculationModelInfoList(MyPage myPage);

}
