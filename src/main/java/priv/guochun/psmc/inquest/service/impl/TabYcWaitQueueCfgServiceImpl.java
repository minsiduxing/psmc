package priv.guochun.psmc.inquest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.model.TabYcWaitQueueCfg;
import priv.guochun.psmc.inquest.service.TabYcWaitQueueCfgService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.page.MyPage;

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

    @Override
    public MyPage selectWaitQueueCfgPage(MyPage page) {
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(page.getQueryParams()!=null && page.getQueryParams().size()>0){
            condition.putAll(page.getQueryParams());
        }
        return baseDao.getMyPage(page, "selectWaitQueueCfgList", condition);
    }
}
