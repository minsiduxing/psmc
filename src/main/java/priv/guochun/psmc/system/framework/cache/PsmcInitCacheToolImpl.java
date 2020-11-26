package priv.guochun.psmc.system.framework.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import priv.guochun.psmc.authentication.operate.service.TabOperateService;
import priv.guochun.psmc.system.common.city.service.CityService;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.common.sysConfig.model.TabSysConfig;
import priv.guochun.psmc.system.common.sysConfig.service.TabSysConfigService;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfigExample;
import priv.guochun.psmc.system.framework.activiti.service.TFlowConfigService;
import priv.guochun.psmc.website.backstage.message.model.TabSysKeyInfo;
import priv.guochun.psmc.website.backstage.message.service.TabSysKeyInfoService;

public class PsmcInitCacheToolImpl implements PsmcInitCacheTool
{
    protected static final  Logger logger  = LoggerFactory.getLogger(PsmcInitCacheToolImpl.class);

    private PsmcCacheFactory psmcCacheFactory;
    private TabOperateService tabOperateService;
    private TabDataDictService tabDataDictService;
    private CityService cityService;
    private TFlowConfigService tFlowConfigService;
    private TabSysConfigService tabSysConfigService;
    private TabSysKeyInfoService tabSysKeyInfoService;
    
    
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
    
    public void workFlowDefinitionInit(){
        logger.debug("开始加载缓存[工作流表单配置]start!!!!!!!!!!!!!!");
        TFlowConfigExample example = new TFlowConfigExample();
        example.setDistinct(true);
        example.setOrderByClause("create_time desc");
        example.createCriteria().andEnabledEqualTo(Short.valueOf("1"));
        List<TFlowConfig> tflowConfigs = tFlowConfigService.getAllTFlowConfig(example);
        Cache cache = psmcCacheFactory.getWorkFlow();
        cache.put(CacheContants.CACHE_SYSTEM_WORKFOLW_DEFINITION, tflowConfigs);
        logger.debug("开始加载缓存[工作流表单配置]end!!!!!!!!!!!!!!");
    }
    
    public void sysConfigInit(){
    	logger.debug("开始加载缓存[系统信息配置]start!!!!!!!!!!!!!!");
    	List<TabSysConfig> sysConfigList = tabSysConfigService.findSysConfigList(null, null);
    	Map<String, TabSysConfig> map = new HashMap<String, TabSysConfig>();
    	for (TabSysConfig sysConfig : sysConfigList) {
    		map.put(sysConfig.getSysCode(), sysConfig);
		}
    	Cache cache = psmcCacheFactory.getCacheSystem();
    	cache.put(CacheContants.CACHE_SYS_CONFIG, map);
    	logger.debug("开始加载缓存[系统信息配置]end!!!!!!!!!!!!!!");
    	
    }
    
    public void sysKeyInfoInit(){
    	logger.debug("开始加载缓存[系统信息配置Key]start!!!!!!!!!!!!!!");
    	List<TabSysKeyInfo> sysConfigList = tabSysKeyInfoService.findSysKeyInfoList(null, null);
    	Map<String, String> map = new HashMap<String, String>();
    	for (TabSysKeyInfo sysConfig : sysConfigList) {
    		map.put(sysConfig.getSysKey(), sysConfig.getSysValue());
    	}
    	Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
    	cache.put(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, map);
    	logger.debug("开始加载缓存[系统信息配置Key]end!!!!!!!!!!!!!!");
    	
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
        }else if(cacheKey.equals(CacheContants.CACHE_SYSTEM_WORKFOLW_DEFINITION)){
        	workFlowDefinitionInit();
        }else if(cacheKey.equals(CacheContants.CACHE_SYS_CONFIG)){
        	sysConfigInit();
        }else if(cacheKey.equals(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY)){
        	sysKeyInfoInit();
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

	public TFlowConfigService gettFlowConfigService() {
		return tFlowConfigService;
	}

	public void settFlowConfigService(TFlowConfigService tFlowConfigService) {
		this.tFlowConfigService = tFlowConfigService;
	}

	public TabSysConfigService getTabSysConfigService() {
		return tabSysConfigService;
	}

	public void setTabSysConfigService(TabSysConfigService tabSysConfigService) {
		this.tabSysConfigService = tabSysConfigService;
	}

	public TabSysKeyInfoService getTabSysKeyInfoService() {
		return tabSysKeyInfoService;
	}

	public void setTabSysKeyInfoService(TabSysKeyInfoService tabSysKeyInfoService) {
		this.tabSysKeyInfoService = tabSysKeyInfoService;
	}
    
    

    
    
}
