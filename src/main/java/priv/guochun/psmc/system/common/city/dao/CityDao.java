package priv.guochun.psmc.system.common.city.dao;

import java.util.List;
import java.util.Map;

public interface CityDao {

    /**
     * 获取系统所有属地资源信息
     * @return
     * @throws Exception
     */
    public List<Map<?,?>> getAllRegion()throws Exception;
    
    
	/**
	 * 获取某一个/一群属地的信息
	 * @param ids 属地ids
	 * @param containMySelf 是否包含本级属地
	 * @param containSub 是否包含下一级属地
	 * @return
	 */
	public List<Map<?,?>> getSubRegionByCityId(String[] ids, boolean containMySelf,boolean containSub)throws Exception;
	
	
	
	
	
}
