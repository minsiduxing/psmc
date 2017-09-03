package priv.guochun.psmc.authentication.operate.dao;

import java.util.List;
import java.util.Map;

public interface TabRoleOperateDao
{

    /**
     * 根据角色id 删除角色和操作的关联关系
     * <p>Description:<p>
     * @param RoleUuids
     * @author guochun 2016-12-22
     */
    public void deleteRoleOperateRelationByRoleUuids(String roleUuids);
    
    /**
     * 保存该角色和所有资源业务操作的关联关系
     * 操作逻辑是先删除 后增加
     * <p>Description:<p>
     * @param roleUuid
     * @param resourceIds
     * @author guochun 2017-2-22
     */
    public void saveRoleResourceOperateRelations(String roleUuid,String resourceIds);
    
    /**
     * 获取某一个角色下的某一个资源的所有操作集合
     * <p>Description:<p>
     * @param roleUuid
     * @param resourceUuid
     * @return
     * @author guochun 2017-2-16
     */
    public List<Map<?,?>> getPrivilegDataListByRoleAndResource(String roleUuid,String resourceUuid);
    
    /**
     * 根据操作表示查询对应配置角色的个数
     * <p>Description:<p>
     * @param operateUuid
     * @return
     * @author wenxiaoming 2017年9月3日
     */
    public int selectRoleCountByOperate(String operateUuid);
}
