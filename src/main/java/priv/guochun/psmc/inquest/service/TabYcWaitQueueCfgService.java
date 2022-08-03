package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.inquest.model.TabYcWaitQueueCfg;

import java.util.List;

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
}
