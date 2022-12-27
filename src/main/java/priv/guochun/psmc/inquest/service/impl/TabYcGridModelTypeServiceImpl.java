package priv.guochun.psmc.inquest.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.service.TabYcGridModelTypeService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网格管理
 */
public class TabYcGridModelTypeServiceImpl implements TabYcGridModelTypeService {

    @Autowired
    private BaseDao baseDao;

    private final String selectGridModelTypeInfoList = "selectGridModelTypeInfoList";

    public MyPage selectGridModelTypeInfoList(MyPage myPage){
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
            condition.putAll(myPage.getQueryParams());
        }
        myPage = baseDao.getMyPage(myPage,selectGridModelTypeInfoList,condition);
        return myPage;
    }

    public List<Map<?,?>> loadGridModelTypeDictList(MyPage myPage){
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
            condition.putAll(myPage.getQueryParams());
        }
        List<?> datalist = baseDao.getMyPage(myPage,selectGridModelTypeInfoList,condition).getDataList();
        List<Map<?,?>> newlist = new ArrayList<Map<?,?>>();

        if(datalist != null && datalist.size()>0){
            for(int i=0;i<datalist.size();i++){
                Map map = (Map)datalist.get(i);
                Map<String,String> newmap = new HashMap<String,String>();
                newmap.put("ID",map.get("GRID_MTYPE_UUID").toString());
                newmap.put("NAME",map.get("GRID_MTYPE_NAME").toString());
                newlist.add(newmap);
            }
        }
        return newlist;
    }
}
