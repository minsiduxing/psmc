package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.Map;

/**
 * 网格管理
 */
public interface TabYcGridBaseInfoService {


    /**
     * 分页查询网格数据
     * @param myPage
     * @return
     */
    MyPage queryGridInfoList(MyPage myPage);

    Map queryGirdInfoByGridUuid(String gridUuid);

    /**
     * 修改网格对应坐标
     * @param gridUuid
     * @param coordinate
     * @return
     */
    public MsgModel updateGirdCoordnate(String gridUuid, String coordinate, String isMaintainCoordinate);
}
