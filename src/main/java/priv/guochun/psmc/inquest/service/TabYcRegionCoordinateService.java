package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有的坐标信息
     * @param queryParams
     * @return
     */
    List queryAllRegionCoordinateInfo(Map<String, Object> queryParams);
}
