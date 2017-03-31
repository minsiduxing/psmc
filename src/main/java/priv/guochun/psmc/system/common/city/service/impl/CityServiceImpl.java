package priv.guochun.psmc.system.common.city.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import priv.guochun.psmc.system.common.city.dao.CityDao;
import priv.guochun.psmc.system.common.city.service.CityService;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;

public class CityServiceImpl implements CityService {

    private CityDao cityDao;
	private PsmcCacheFactory psmcCacheFactory;
	private static final  Logger logger  = LoggerFactory.getLogger(CityServiceImpl.class.getName());
	
	@Override
	public List<Map<?,?>> getAllRegion() {
		try {
		    return cityDao.getSubRegionByCityId(new String[]{"00"}, true, true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
            return null;
        }
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public List<Map<?,?>> getAllRegion(String[] ids,boolean containMySelf,boolean containSub){
	    Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_DATA_CITY, List.class);
        List<Map<?,?>> regionList = getRegion(list,ids,containMySelf,containSub);
        return regionList;
	}
	
	private List<Map<?,?>> getRegion(List<Map<?,?>> regionList,String[] ids,
	                                        boolean containMySelf,boolean containSub){
	    List<Map<?,?>> newList = new ArrayList<Map<?,?>>();
	    for(int i=0;i<regionList.size();i++){
	        Map<?,?> map = regionList.get(i);
	        String id = map.get("ID").toString();
	        String pid = map.get("PID").toString();
	        if(containMySelf){
	            for(int x=0;x<ids.length;x++){
	                if(id.equals(ids[x])){
	                    newList.add(map);
	                }
	            }
	        }
	        if(containSub){
                for(int x=0;x<ids.length;x++){
                    if(pid.equals(ids[x])){
                        newList.add(map);
                    }
                }
            }
	        
	    }
	    return newList;
	}
	
	
	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
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
