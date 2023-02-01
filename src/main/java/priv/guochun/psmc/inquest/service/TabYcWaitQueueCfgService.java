package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.inquest.model.TabYcWaitQueueCfg;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;
import java.util.Map;

/**
 * 勘验轮候配置
 */
public interface TabYcWaitQueueCfgService {

    /**
     * @description 查询轮候配置列表
     * @author wangt
     * @create 2022/7/30 17:55
     */
    List<TabYcWaitQueueCfg> selectWaitQueueCfgList(String orgCode);
    /**
     * @description 查询轮候配置分页
     * @author wangt
     * @create 2022/7/30 17:55
     */
    MyPage selectWaitQueueCfgPage(MyPage page);


    MsgModel queryWaitQueueCfg(Map<String,Object> param);
}
