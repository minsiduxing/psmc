package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

/**
 * @description 区域坐标服务
 * @author wangt
 * @create 2022/12/28 16:11
 */
public interface TabYcRegionCoordinateService {

    /**
     * 查询分页列表
     * @param page
     * @return
     */
    MyPage selectRegionCoordinatePage(MyPage page);
}
