package priv.guochun.psmc.system.framework.cache;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import priv.guochun.psmc.authentication.operate.service.TabOperateService;

public class PsmcInitCacheToolImpl implements PsmcInitCacheTool
{
    protected static final  Logger logger  = LoggerFactory.getLogger(PsmcInitCacheToolImpl.class);

    private TabOperateService tabOperateService;
    private PsmcCacheFactory psmcCacheFactory;
    
    public void resourcePermitOperatesInit(){
        
        logger.debug("开始加载缓存[系统所有资源业务操作]start!!!!!!!!!!!!!!");
        List<Map<?,?>> sysResourcePermitOperates = tabOperateService.getPermitOperatesByRoleUuid(null);
        Cache cache = psmcCacheFactory.getCacheSystem();
        cache.put(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE, sysResourcePermitOperates);
        logger.debug("开始加载缓存[系统所有资源业务操作]end!!!!!!!!!!!!!!");
        
    }
    
    public void initCache(Object key){
        if(key == null)
            return;
        String cacheKey = key.toString();
        if(cacheKey.equals(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE))
        {
            resourcePermitOperatesInit();
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

    

    
    
}
