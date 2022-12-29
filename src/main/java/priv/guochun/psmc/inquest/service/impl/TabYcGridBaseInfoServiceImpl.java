package priv.guochun.psmc.inquest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.service.TabYcGridBaseInfoService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.HashMap;
import java.util.Map;


/**
 * 网格管理
 */
public class TabYcGridBaseInfoServiceImpl implements TabYcGridBaseInfoService {

    @Autowired
    private BaseDao baseDao;

    private final String selectGridInfoList = "selectGridInfoList";

    public MyPage queryGridInfoList(MyPage myPage){
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
            condition.putAll(myPage.getQueryParams());
        }
        myPage = baseDao.getMyPage(myPage,selectGridInfoList,condition);
        return myPage;
    }

    public Map queryGirdInfoByGridUuid(String gridUuid){
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("gridUuid",gridUuid);
        return (Map)baseDao.queryForObject(selectGridInfoList,condition);
    }
}
