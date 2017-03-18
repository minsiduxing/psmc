package priv.guochun.psmc.system.common.dict.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.common.dict.dao.TabDataDictDao;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;

public class TabDataDictServiceImpl implements TabDataDictService {
	
	
	TabDataDictDao tabDataDictDao;
	private static final  Logger logger  = LoggerFactory.getLogger(TabDataDictServiceImpl.class.getName());
	@Override
	public List getDictDataList(int dict_type) {
		try {
			return tabDataDictDao.getDictDataList(dict_type);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}
	
	
	@Override
    public Map getDictDataMapByIdAsKey(int dict_type)
    {
	    List list = getDictDataList(dict_type);
        return ListToMap(list,0);
    }
	
	@Override
    public Map getDictDataMapByNameAsKey(int dict_type)
    {
        List list = getDictDataList(dict_type);
        return ListToMap(list,1);
    }


	private Map ListToMap(List<Map> list,int flag){
        Map map = new HashMap();
        if(list !=null && list.size()>0){
            for(int i=0;i<list.size();i++){  
                Map mapObj = (Map)list.get(i);
                if(1==flag)
                    map.put(mapObj.get("NAME")!=null?mapObj.get("NAME").toString():"",
                            mapObj.get("ID")!=null?mapObj.get("ID").toString():"");
                else
                    map.put(mapObj.get("ID")!=null?mapObj.get("ID").toString():"",
                            mapObj.get("NAME")!=null?mapObj.get("NAME").toString():"");
            }
        }
        return map;
    }
	
	public List getDictDataList(String dict_no){
		try {
			return tabDataDictDao.getDictDataList(dict_no);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}

    public TabDataDictDao getTabDataDictDao() {
		return tabDataDictDao;
	}
	public void setTabDataDictDao(TabDataDictDao tabDataDictDao) {
		this.tabDataDictDao = tabDataDictDao;
	}
	

}
