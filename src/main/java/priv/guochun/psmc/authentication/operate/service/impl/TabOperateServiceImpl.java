package priv.guochun.psmc.authentication.operate.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.authentication.operate.dao.TabOperateDao;
import priv.guochun.psmc.authentication.operate.dao.TabRoleOperateDao;
import priv.guochun.psmc.authentication.operate.model.TabOperate;
import priv.guochun.psmc.authentication.operate.service.TabOperateService;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcInitCacheTool;
import priv.guochun.psmc.system.util.UUIDGenerator;

public class TabOperateServiceImpl implements TabOperateService {
	
	private TabOperateDao tabOperateDao;
	
	private TabRoleOperateDao tabRoleOperateDao;
	
	private PsmcInitCacheTool psmcInitCacheTool;
	
	@Override
	public List<Map<?,?>> getPermitOperatesByRoleUuid(String role_uuid) {
		return tabOperateDao.getPermitOperatesByRoleUuid(role_uuid);
	}

	@Override
	public List getTabOperatesByRoleUuidAndResourceUuid(String role_uuid,
			String resource_uuid) {
		return tabOperateDao.getTabOperates(role_uuid, resource_uuid);
	}
	
	@Override
	public boolean deleteTabOperatesByResourceUuid(String resourceUuid){
		tabOperateDao.deleteTabOperatesByResourceUuid(resourceUuid);
		//刷新缓存
	    psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
		return true;
	}
	
	@Override
    public Integer getTabOperateOrderNum()
    {
	    return tabOperateDao.getTabOperateOrderNum();
    }
	
    @Override
    public List getTabOperatesBusinessMethod(String resourceuuid)
    {
        return tabOperateDao.getTabOperatesByResourceUuid(resourceuuid);
    }
    
    @Override
    public void saveOrUpdateResOperateBusinessMethod(TabOperate tabResourceOperate)
    {
    	TabOperate tabOperate = tabOperateDao.selectOpertateById(tabResourceOperate);
        if (tabOperate != null){
            tabOperateDao.updateResOperateConfig(tabResourceOperate);
        }else{
            String uuid = UUIDGenerator.createUUID();
            tabResourceOperate.setUuid(uuid);
            tabOperateDao.saveResOperateConfig(tabResourceOperate);
        }
        
        //刷新缓存
	    psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
    }

    @Override
    public int selectRoleCountByOperate(String operateUuid)
    {
        int count = tabRoleOperateDao.selectRoleCountByOperate(operateUuid);
        return count;
    }

    @Override
    public int deleteOperateBusinessMethod(String operateUuid)
    {
        int count = tabOperateDao.deleteOperate(operateUuid);
        //刷新缓存
	    psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
        return count;
    }
    
    @Override
    public int selectOperateCountByNo(String operateUuid, String operateNo)
    {
        int count = tabOperateDao.selectOperateCountByNo(operateUuid, operateNo);
        return count;
    }
    

	@Override
	public TabOperate selectOpertateById(TabOperate tabResourceOperate) {
		return tabOperateDao.selectOpertateById(tabResourceOperate);
	}
	
	public TabOperateDao getTabOperateDao() {
		return tabOperateDao;
	}

	public void setTabOperateDao(TabOperateDao tabOperateDao) {
		this.tabOperateDao = tabOperateDao;
	}
	
    public TabRoleOperateDao getTabRoleOperateDao()
    {
        return tabRoleOperateDao;
    }
    public void setTabRoleOperateDao(TabRoleOperateDao tabRoleOperateDao)
    {
        this.tabRoleOperateDao = tabRoleOperateDao;
    }
    
    public PsmcInitCacheTool getPsmcInitCacheTool()
    {
        return psmcInitCacheTool;
    }

    public void setPsmcInitCacheTool(PsmcInitCacheTool psmcInitCacheTool)
    {
        this.psmcInitCacheTool = psmcInitCacheTool;
    }
}