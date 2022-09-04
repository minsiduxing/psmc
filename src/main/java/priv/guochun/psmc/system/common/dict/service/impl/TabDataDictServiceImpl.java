package priv.guochun.psmc.system.common.dict.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabDataDictServiceImpl implements TabDataDictService {
	
	private PsmcCacheFactory psmcCacheFactory;

    private final static String getDictDataList = "getDictDataList";
    @Autowired
    private BaseDao baseDao;
	@Override
	public List<Map<?,?>> getDictDataList(){
	    List<Map<?,?>> list =  baseDao.queryForList(getDictDataList);
        return list;
	}

    public MyPage getDictDataList(MyPage page){
        return baseDao.getMyPage(page,getDictDataList,page.getQueryParams());
    }
	
    public List<Map<?,?>> getDictDataList(String dict_no,String parentDictType){
	    Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_DATA_DICT, List.class);
        if(StringUtils.isBlank(dict_no) || list == null || list.size()<1)
            return null;
        else{
            List<Map<?,?>> newList = new ArrayList<Map<?,?>>();
            for(int i=0;i<list.size();i++){
                Map<?,?> map = list.get(i);
                String DICT_NO = map.get("DICT_NO").toString();
                String PARENT_DICT_TYPE = map.get("PARENT_DICT_TYPE")!=null?map.get("PARENT_DICT_TYPE").toString():null;
                if(DICT_NO.equals(dict_no))
                {
                    if(!StringUtils.isBlank(parentDictType)){
                        if(parentDictType.equals(PARENT_DICT_TYPE)){
                            newList.add(map);
                        }
                    }else
                        newList.add(map);
                }
            }
            return newList;
        }
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
