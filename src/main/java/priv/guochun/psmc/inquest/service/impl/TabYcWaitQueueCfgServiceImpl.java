package priv.guochun.psmc.inquest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.model.TabYcWaitQueueCfg;
import priv.guochun.psmc.inquest.service.TabYcWaitQueueCfgService;
import priv.guochun.psmc.system.framework.dao.BaseDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TabYcWaitQueueCfgServiceImpl implements TabYcWaitQueueCfgService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<TabYcWaitQueueCfg> selectWaitQueueCfgList(String orgCode){
        Map<String, Object> param = new HashMap<>();
        param.put("orgCode", orgCode);
        return baseDao.queryForList("selectWaitQueueCfgList", param);
    }
}
