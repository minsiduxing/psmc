package priv.guochun.psmc.system.common.dict.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.Cache;

import priv.guochun.psmc.system.common.dict.dao.TabDataDictDao;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;

public class TabDataDictServiceImpl implements TabDataDictService {
	
	
	public TabDataDictDao tabDataDictDao;
	private PsmcCacheFactory psmcCacheFactory;
	
	@Override
	public List<Map<?,?>> getDictDataList(){
	    List<Map<?,?>> list =  tabDataDictDao.getDictDataListByDictNo(null);
        return list;
	    
	}
//
//	private Map ListToMap(List<Map> list,int flag){
//        Map map = new HashMap();
//        if(list !=null && list.size()>0){
//            for(int i=0;i<list.size();i++){  
//                Map mapObj = (Map)list.get(i);
//                if(1==flag)
//                    map.put(mapObj.get("NAME")!=null?mapObj.get("NAME").toString():"",
//                            mapObj.get("ID")!=null?mapObj.get("ID").toString():"");
//                else
//                    map.put(mapObj.get("ID")!=null?mapObj.get("ID").toString():"",
//                            mapObj.get("NAME")!=null?mapObj.get("NAME").toString():"");
//            }
//        }
//        return map;
//    }
	
	@SuppressWarnings("unchecked")
    public List<Map<?,?>> getDictDataList(String dict_no){
	    Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_DATA_DICT, List.class);
        if(StringUtils.isBlank(dict_no) || list == null || list.size()<1)
            return null;
        else{
            List<Map<?,?>> newList = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Map<?,?> map = list.get(i);
                String DICT_NO = map.get("DICT_NO").toString();
                if(DICT_NO.equals(dict_no))
                newList.add(map);
            }
            return newList;
        }
	}
	

	

    public TabDataDictDao getTabDataDictDao() {
		return tabDataDictDao;
	}
	public void setTabDataDictDao(TabDataDictDao tabDataDictDao) {
		this.tabDataDictDao = tabDataDictDao;
	}

    public PsmcCacheFactory getPsmcCacheFactory()
    {
        return psmcCacheFactory;
    }

    public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory)
    {
        this.psmcCacheFactory = psmcCacheFactory;
    }
	

}
