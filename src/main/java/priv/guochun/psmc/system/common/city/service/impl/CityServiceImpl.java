package priv.guochun.psmc.system.common.city.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.common.city.dao.CityDao;
import priv.guochun.psmc.system.common.city.service.CityService;

public class CityServiceImpl implements CityService {

	CityDao cityDao;
	private static final  Logger logger  = LoggerFactory.getLogger(CityServiceImpl.class.getName());
	
	@Override
	public List<Map<?,?>> getAllRegion() {
		return getAllRegion(new String[]{"00"}, true,true);
	}
	
	public List<Map<?,?>> getAllRegion(String[] ids,boolean containMySelf,boolean containSub){
		try {
			return cityDao.getSubRegionByCityId(ids, containMySelf, containSub);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Map getAllRegionMapOfKeyIsCityId(){
		Map map = new HashMap();
		List<Map<?,?>> list = this.getAllRegion();
		return ListToMap(list,0);
	}
	
	@Override
	public Map getAllRegionMapOfKeyIsCityName(){
		Map map = new HashMap();
		List<Map<?,?>> list = this.getAllRegion();
		return ListToMap(list,1);
	}
	
	@Override
    public Map getAllRegionMapOfKeyIsCityName(String[] ids){
        Map map = new HashMap();
        List<Map<?,?>> list = this.getAllRegion(ids, true, false);
        return ListToMap(list,1);
    }
	
	

	private Map ListToMap(List<Map<?,?>> list,int flag){
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
	
	
	@Override
	public Map getCityMapOfKeyIsCityId() {
		List<Map<?,?>> list;
		try {
			list = cityDao.getSubRegionByCityId(new String[]{"00"}, false, true);
			return ListToMap(list,0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Map getCityMapOfKeyIsCityName() {
		List<Map<?,?>> list;
		try {
			list = cityDao.getSubRegionByCityId(new String[]{"00"}, false, true);
			return ListToMap(list,1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Map getCountyMapOfKeyIsCityId(String[] cityIds) {
		List<Map<?,?>> list;
		try {
			list = getCountyList(cityIds);
			return ListToMap(list,0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Map getCountyMapOfKeyIsCityName(String[] cityIds) {
		List<Map<?,?>> list;
		try {
			list = getCountyList(cityIds);
			return ListToMap(list,1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Map<?,?>> getCountyList(String[] cityIds) {
		List<Map<?,?>> list;
		try {
			list = cityDao.getSubRegionByCityId(cityIds, false, true);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return null;
		}
	}
	
	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	
	

}
