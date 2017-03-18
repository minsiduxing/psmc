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
	 * 得到所有属地集合,并且将集合数据转换成map返回,map的key为cityid
	 * @return
	 */
	public Map getAllRegionMapOfKeyIsCityId();
	
	/**
	 * 得到所有属地集合,并且将集合数据转换成map返回,map的key为cityName
	 * @return
	 */
	public Map getAllRegionMapOfKeyIsCityName();
	
	public Map getAllRegionMapOfKeyIsCityName(String[] ids);
	
	/**
	 * 得到某一个（一群）属地下的子属地信息
	 * @param ids 属地id数组集合
	 * @param containMySelf 是否包含自身属地信息
	 * @param containSub 是否包含子属地信息
	 * @return
	 */
	public List<Map<?,?>> getAllRegion(String[] ids,boolean containMySelf,boolean containSub);
	
	/**
	 * 得到系统下所有地市(一级属地)集合,并且将集合数据转换成map返回,map的key为cityid
	 * @return
	 */
	public Map getCityMapOfKeyIsCityId();
	
	/**
	 * 得到系统下所有地市(一级属地)集合,并且将集合数据转换成map返回,map的key为cityName
	 * @return
	 */
	public Map getCityMapOfKeyIsCityName();
	
	/**
	 * 得到某一个属地的子属地信息集合（不包含当前自身属地信息）
	 * @param cityIds
	 * @return
	 */
	
	public List<Map<?,?>> getCountyList(String[] cityIds);
	
	/**
	 * 得到某一个属地的子属地信息（不包含当前自身属地信息）
	 * 并且将集合数据转换成map返回,map的key为cityid
	 * @param cityIds
	 * @return
	 */
	
	public Map getCountyMapOfKeyIsCityId(String[] cityIds);
	
	/**
	 * 得到某一个属地的子属地信息（不包含当前自身属地信息）
	 * 并且将集合数据转换成map返回,map的key为cityName
	 * @param cityIds
	 * @return
	 */
	public Map getCountyMapOfKeyIsCityName(String[] cityIds);
	

	
	
	
}
