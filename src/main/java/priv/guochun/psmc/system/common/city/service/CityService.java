package priv.guochun.psmc.system.common.city.service;

import java.util.List;
import java.util.Map;

public interface CityService {
    
	/**
	 * 得到所有属地集合
	 * @return
	 */
	public List<Map<?,?>> getAllRegion();
	
	/**
	 * 得到某一个（一群）属地下的子属地信息
	 * @param ids 属地id数组集合
	 * @param containMySelf 是否包含自身属地信息
	 * @param containSub 是否包含子属地信息
	 * @return
	 */
	public List<Map<?,?>> getAllRegion(String[] ids,boolean containMySelf,boolean containSub);
	
	
	
	
}
