package priv.guochun.psmc.authentication.resource.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.resource.model.TabResource;

public interface TabResourceService
{
    
    
    /**
     * 得到系统所有资源菜单信息,包含根节点
     * <p>Description:<p>
     * @return
     * @author guochun 2016-8-19
     */
   
    public List getSystemAllResourcesBusinessMethod();
    
    /**
     * 得到系统所有资源菜单信息,包含根节点，如果该角色拥有此节点则默认选中
     * <p>Description:<p>
     * @return
     * @author guochun 2016-8-19
     */
    public List<Map<?,?>> getSystemAllResourcesBelongRole(String roleUuid);
    
    /**
     * 得到当前角色所拥有的所有资源
     * <p>Description:<p>
     * @return
     * @author guochun 2016-8-19
     */
    public List<Map<?,?>> getResourcesBelongRole(String roleUuid);
    
    
    /**
     * 更新资源和角色关联关系 
     * 会级联更新角色和操作的关联关系
     * <p>Description:<p>
     * @param roleUuid
     * @return
     * @author guochun 2016-12-20
     */
    public boolean saveOrUpateResourceRoleRelationBusinessMethod(String resourceIds,String roleUuid);
    
    /**
     * 得到某个角色下、某个资源和操作的关系集合
     * <p>Description:<p>
     * @param roleUuid
     * @param resourceUuid
     * @return
     * @author guochun 2017-2-16
     */
    public List<Map<?,?>> getPrivilegDataListByRoleAndResource(String roleUuid,String resourceUuid);
    
    /**
     * 保存某一个角色下的某一个资源下，角色和操作的关联关系
     * @param roleUuid
     * @param resourceUuid
     * @param operate_uuids
     * @return
     */
    public boolean saveRoleResourceOperateRelationsBusinessMethod(String roleUuid,String resourceUuid,String operate_uuids);
    
    /**
     * 持久化资源信息
     * <p>Description:<p>
     * @param tabResource
     * @return
     * @author guochun 2017-2-23
     */
    public String saveOrUpdateTabResourceBusinessMethod(TabResource tabResource,User loginUser);
    
    /**
     * 根据资源id删除资源信息 并且级联删除资源下的业务操作
     * 前置条件：资源和角色无关联关系
     * <p>Description:<p>
     * @param resourceUuid
     * @return JSONObject
     * @author guochun 2017-2-23
     */
    public JSONObject deleteTabResourceBusinessMethod(String resourceUuid);
    
    /**
     * 修改资源的归属父资源
     * @param resourceUuid
     * @param parentResourceUuid
     * @return
     */
    public boolean updateResourceTheParentUuidBusinessMethod(String resourceUuid,String parentResourceUuid);
    /**
     * 修改资源名称
     * @param resourceUuid
     * @param newName
     * @return
     */
    public JSONObject updateResourceTheNameBusinessMethod(String resourceUuid,String newName);
}
