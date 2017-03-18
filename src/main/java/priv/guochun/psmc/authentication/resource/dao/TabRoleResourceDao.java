package priv.guochun.psmc.authentication.resource.dao;

import java.util.List;
import java.util.Map;

public interface TabRoleResourceDao
{

    /**
     * 根据角色ID 删除某个角色和资源的关联关系
     * 级联删除角色和操作的关联关系
     * <p>Description:<p>
     * @param RoleUuid
     * @author guochun 2016-12-22
     */
    public void deleteRoleResouceRelationByRoleUuids(String roleUuids);
    /**
     * 更新某个角色和资源的关联关系 
     * 处理逻辑是先删除 后增加
     * <p>Description:<p>
     * @param roleUuid
     * @param resourceIds
     * @author guochun 2016-12-20
     */
    public void saveResourcesRoleRelations(String roleUuid,String resourceIds);
   
    
    /**
     * 删除该角色所拥有的 某一个资源下的所有业务操作
     * @param roleUuid
     * @param resourceId
     */
    public void deleteRRORelationsByRoleUuidWithResourceUuid(String roleUuid,String resourceId);
    
    
    /**
     * 保存某一个角色下的某一个资源下，角色和操作的关联关系
     * 处理逻辑是先删除 后增加
     * @param roleUuid
     * @param resourceUuid
     * @param operate_uuids
     */
    
    public void saveRoleResourceOperateRelations(String roleUuid,String resourceUuid,String operate_uuids);
    
    /**
     * 根据资源ID，获取资源和角色关联关系集合
     * <p>Description:<p>
     * @param resourceUuid
     * @return
     * @author guochun 2017-2-23
     */
    public List<Map<?,?>> getRoleResourceRelations(String resourceUuid);
}
