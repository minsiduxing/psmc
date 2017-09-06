package priv.guochun.psmc.authentication.resource.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.operate.dao.TabRoleOperateDao;
import priv.guochun.psmc.authentication.operate.service.TabOperateService;
import priv.guochun.psmc.authentication.resource.dao.TabResourceDao;
import priv.guochun.psmc.authentication.resource.dao.TabRoleResourceDao;
import priv.guochun.psmc.authentication.resource.model.TabResource;
import priv.guochun.psmc.authentication.resource.service.TabResourceService;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcInitCacheTool;
import priv.guochun.psmc.system.framework.util.ResourceEnum;
import priv.guochun.psmc.system.framework.util.ReturnModel;
import priv.guochun.psmc.system.util.UUIDGenerator;

public class TabResourceServiceImpl implements TabResourceService
{
    protected static final  Logger logger  = LoggerFactory.getLogger(TabResourceServiceImpl.class);

    private TabResourceDao tabResourceDao;
    private TabRoleResourceDao tabRoleResourceDao;
    private TabRoleOperateDao tabRoleOperateDao;
    private TabOperateService tabOperateService;
    private PsmcInitCacheTool psmcInitCacheTool;
    
    
    public JSONObject deleteTabResourceBusinessMethod(String resourceUuid){
        JSONObject returnObj = null;
    	if(StringUtils.isBlank(resourceUuid)){
    		String msg ="系统该方法参数为空!"; 
    		logger.warn(msg);
    		throw new NullPointerException(msg);
    	}
    	List<Map<?,?>> subLists = this.tabResourceDao.getSubResourcesByResourceId(resourceUuid, null, false, null);
    	if(subLists != null && subLists.size()>0){
    	    String msg ="该资源下存在子资源,无法删除.请先手工删除子资源或将子资源挂接到其他资源下.";
    		logger.warn(msg);
    		returnObj = ReturnModel.createFailJSONObject(msg);
    		return returnObj;
    	}
    	
        List<Map<?,?>> rrRelations  = tabRoleResourceDao.getRoleResourceRelations(resourceUuid);
        if(rrRelations != null && rrRelations.size()>0){
            String msg ="该资源已被角色所拥有,无法删除.请先解除该资源和角色的关联关系.";
            logger.warn(msg);
            returnObj = ReturnModel.createFailJSONObject(msg);
            return returnObj;
        }else{
        	//这里只需要删除资源的业务操作即可，因为如果资源不属于某个角色，
        	//那么角色也不拥有对该资源的业务操作，无需删除该业务操作。
        	tabOperateService.deleteTabOperatesByResourceUuid(resourceUuid);
        	tabResourceDao.deleteResource(resourceUuid);
        	//刷新缓存
        	psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
            returnObj = ReturnModel.createSuccessJSONObject();
            return returnObj;
        }
    }
    
    @Override
    public boolean updateResourceTheParentUuidBusinessMethod(String resourceUuid,String parentResourceUuid){
    	tabResourceDao.updateResourceTheParentUuid(resourceUuid,parentResourceUuid);
    	return true;
    }
    
    @Override
    public JSONObject updateResourceTheNameBusinessMethod(String resourceUuid,String newName){
    	tabResourceDao.updateResourceTheName(resourceUuid,newName);
    	//刷新缓存
        psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
    	return ReturnModel.createSuccessJSONObject();
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    public List getSystemAllResourcesBusinessMethod()
    {
        return tabResourceDao.getSystemAllResourcesBelongRole(null);
    }

    @Override
    public List<Map<?,?>> getSystemAllResourcesBelongRole(String roleUuid){
        return tabResourceDao.getSystemAllResourcesBelongRole(roleUuid);
    }
    
    @Override
    public List<Map<?,?>> getResourcesBelongRole(String roleUuid){
        return tabResourceDao.getResourcesBelongRole(roleUuid);
    }
    
    
    @Override
    public boolean saveOrUpateResourceRoleRelationBusinessMethod(String resourceIds, String roleUuid)
    {
        if(StringUtils.isBlank(roleUuid) || resourceIds == null){
            logger.warn("角色ID或资源ID为空，无法进行处理....");
            return false;
        }else{
            tabRoleResourceDao.saveResourcesRoleRelations(roleUuid, resourceIds);
            tabRoleOperateDao.saveRoleResourceOperateRelations(roleUuid, resourceIds);
            //刷新缓存
            psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
            return true;
        }
    }
    
    @Override
    public List<Map<?,?>> getPrivilegDataListByRoleAndResource(String roleUuid,String resourceUuid){
        if(StringUtils.isBlank(roleUuid) || StringUtils.isBlank(resourceUuid)){
            logger.warn("角色ID或资源ID为空，无法进行处理....");
            throw new PsmcBuisnessException("角色ID或资源ID为空，无法进行处理....");
        }else{
            List<Map<?,?>> list = tabRoleOperateDao.getPrivilegDataListByRoleAndResource(roleUuid, resourceUuid);
            return list;
        }
    }
    
    public boolean saveRoleResourceOperateRelationsBusinessMethod(String roleUuid,String resourceUuid,String operate_uuids){
        if(StringUtils.isBlank(roleUuid) || StringUtils.isBlank(resourceUuid)
        		|| StringUtils.isBlank(operate_uuids)){
            logger.warn("角色ID或资源ID或操作ID为空，无法进行处理....");
            return false;
        }else{
            tabRoleResourceDao.saveRoleResourceOperateRelations(roleUuid, resourceUuid,operate_uuids);
            //刷新缓存
            psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
            return true;
        }
    }
    
    public String saveOrUpdateTabResourceBusinessMethod(TabResource tabResource,User loginUser){
            String result = null;
            String parentRId = tabResource.getParentResourceUuid();
            if(tabResource == null || StringUtils.isBlank(parentRId)){
                logger.warn("资源对象或parentRId为空，无法进行处理....");
                return result;
            }
            Map<?,?>  parentRmap = this.tabResourceDao.getResource(parentRId, null, null);
            String parentRtype = parentRmap.get("RESOURCE_TYPE").toString();
            if(ResourceEnum.ResourceType1.getIndex() == Integer.parseInt(parentRtype)){
                tabResource.setResourceType(ResourceEnum.ResourceType2.getIndex());
                tabResource.setRemark(ResourceEnum.ResourceType2.getName());
            }else{
                tabResource.setResourceType(ResourceEnum.ResourceType3.getIndex());
                tabResource.setRemark(ResourceEnum.ResourceType3.getName());
            }
            
            String resourceId = tabResource.getId();
            if(StringUtils.isNotBlank(resourceId)){
                tabResourceDao.updateResource(tabResource);
            }else{  
                Integer ordernum = tabResourceDao.getTabResourceOrderNum();
                tabResource.setOrdernum(ordernum);
                tabResource.setCreatorName(loginUser.getAccountName());
                tabResource.setCreateTime(new Date());
                tabResource.setId(UUIDGenerator.createUUID());
                tabResourceDao.saveResource(tabResource);
            }
            //刷新缓存
            psmcInitCacheTool.initCache(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE);
            result = tabResource.getId();
            return result;
    }

    @Override
    public Integer getTabResourceOrderNum()
    {
        Integer ordernum = tabResourceDao.getTabResourceOrderNum();
        return ordernum;
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    public Map<?, ?> getTabResourceByUuid(String resourceUuid)
    {
        Map map = tabResourceDao.getTabResourceByUuid(resourceUuid);
        return map;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Map<String,String> saveOrUpdateTabResourceBusinessMethod(TabResource tabResource)
    {
        if(tabResource == null || StringUtils.isBlank(tabResource.getId())){
            logger.warn("主键为空,无法进行对象持久化操作!");
            return null;
        }
        Map map = tabResourceDao.getTabResourceByUuid(tabResource.getId());
        if(map == null){
            tabResourceDao.saveResource(tabResource);
        }else{
            tabResourceDao.updateResource(tabResource);
        }
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("uuid", tabResource.getId());
        resultMap.put("parentResourceUuid", tabResource.getParentResourceUuid());
        resultMap.put("resourceName", tabResource.getResourceName());
        return resultMap;
    }

	public TabResourceDao getTabResourceDao() {
		return tabResourceDao;
	}

	public void setTabResourceDao(TabResourceDao tabResourceDao) {
		this.tabResourceDao = tabResourceDao;
	}
    
    public TabRoleResourceDao getTabRoleResourceDao()
    {
        return tabRoleResourceDao;
    }
    public void setTabRoleResourceDao(TabRoleResourceDao tabRoleResourceDao)
    {
        this.tabRoleResourceDao = tabRoleResourceDao;
    }
    public TabRoleOperateDao getTabRoleOperateDao()
    {
        return tabRoleOperateDao;
    }
    public void setTabRoleOperateDao(TabRoleOperateDao tabRoleOperateDao)
    {
        this.tabRoleOperateDao = tabRoleOperateDao;
    }
	public TabOperateService getTabOperateService() {
		return tabOperateService;
	}
	public void setTabOperateService(TabOperateService tabOperateService) {
		this.tabOperateService = tabOperateService;
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
