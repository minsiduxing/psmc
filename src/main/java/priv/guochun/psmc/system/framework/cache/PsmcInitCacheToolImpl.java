package priv.guochun.psmc.system.framework.cache;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import priv.guochun.psmc.authentication.operate.service.TabOperateService;
import priv.guochun.psmc.system.common.city.service.CityService;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;

public class PsmcInitCacheToolImpl implements PsmcInitCacheTool
{
    protected static final  Logger logger  = LoggerFactory.getLogger(PsmcInitCacheToolImpl.class);

    private PsmcCacheFactory psmcCacheFactory;
    private TabOperateService tabOperateService;
    private TabDataDictService tabDataDictService;
    private CityService cityService;
    
    public void resourcePermitOperatesInit(){
        logger.debug("开始加载缓存[系统所有资源业务操作]start!!!!!!!!!!!!!!");
        List<Map<?,?>> sysResourcePermitOperates = tabOperateService.getPermitOperatesByRoleUuid(null);
        Cache cache = psmcCacheFactory.getCacheSystem();
        cache.put(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE, sysResourcePermitOperates);
        logger.debug("开始加载缓存[系统所有资源业务操作]end!!!!!!!!!!!!!!");
    }
    
    public void dataDictInit(){
        logger.debug("开始加载缓存[系统数据字典]start!!!!!!!!!!!!!!");
        List<Map<?,?>> sysResourcePermitOperates = tabDataDictService.getDictDataList();
        Cache cache = psmcCacheFactory.getCacheSystem();
        cache.put(CacheContants.CACHE_SYSTEM_DATA_DICT, sysResourcePermitOperates);
        logger.debug("开始加载缓存[系统数据字典]end!!!!!!!!!!!!!!");
    }
    
    
    public void tabCityInit(){
        logger.debug("开始加载缓存[系统属地]start!!!!!!!!!!!!!!");
        List<Map<?,?>> sysResourcePermitOperates = cityService.getAllRegion();
        Cache cache = psmcCacheFactory.getCacheSystem();
        cache.put(CacheContants.CACHE_SYSTEM_DATA_CITY, sysResourcePermitOperates);
        logger.debug("开始加载缓存[系统属地]end!!!!!!!!!!!!!!");
    }
    
    public void initCache(Object key){
        if(key == null)
            return;
        String cacheKey = key.toString();
        if(cacheKey.equals(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE)){
            resourcePermitOperatesInit();
        }else if(cacheKey.equals(CacheContants.CACHE_SYSTEM_DATA_DICT)){
            dataDictInit();
        }else if(cacheKey.equals(CacheContants.CACHE_SYSTEM_DATA_CITY)){
            tabCityInit();
        }else{
            logger.warn("缓存["+cacheKey+"]没有可以进行初始化的方法!!!");
        }
    }
    
    
    
    
    public TabOperateService getTabOperateService()
    {
        return tabOperateService;
    }
    public void setTabOperateService(TabOperateService tabOperateService)
    {
        this.tabOperateService = tabOperateService;
    }

    public PsmcCacheFactory getPsmcCacheFactory()
    {
        return psmcCacheFactory;
    }

    public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory)
    {
        this.psmcCacheFactory = psmcCacheFactory;
    }

    public TabDataDictService getTabDataDictService()
    {
        return tabDataDictService;
    }

    public void setTabDataDictService(TabDataDictService tabDataDictService)
    {
        this.tabDataDictService = tabDataDictService;
    }

    public CityService getCityService()
    {
        return cityService;
    }

    public void setCityService(CityService cityService)
    {
        this.cityService = cityService;
    }
    
    

    
    
}
