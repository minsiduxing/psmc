package priv.guochun.psmc.authentication.resource.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.resource.model.TabResource;


public interface TabResourceDao
{
    
    /**
     * 获取该资源id下的所有资源信息
     * <p>Description:<p>
     * @param resourceId
     * @param resourceType 如果不为空,则限定资源类型
     * @param ContainSelf 返回信息是否包含自身 true /false
     * @param roleId 如果不为空,则限定必须是该角色下的资源
     * @return
     * @author guochun 2016-8-19
     */

    public List<Map<?,?>> getSubResourcesByResourceId(String resourceId,
                                            Integer resourceType,
                                            boolean ContainSelf,
                                            String roleId,Integer isView);
    /**
     * 得到某一个角色的某一个资源
     * @param resourceId 资源主键
     * @param resourceType 如果不为空,则限定资源类型
     * @param roleId 如果不为空,则限定必须是该角色下的资源
     * @return
     */
    public Map<?,?> getResource(String resourceId,Integer resourceType,String roleUuid);
    
    public Map<?,?> getResource(String resourceId,Integer resourceType,String roleUuid,Integer isView);
    
    /**
     * 获取系统资源树，并对隶属于该角色的资源默认check
     * <p>Description:<p>
     * @param roleId
     * @return
     * @author guochun 2016-12-16
     */
    public List<Map<?,?>> getSystemAllResourcesBelongRole(String roleUuid);
    
    /**
     * 得到当前角色所拥有的所有资源
     * <p>Description:<p>
     * @param roleUuid
     * @return
     * @author guochun 2017-2-15
     */
    public List<Map<?,?>> getResourcesBelongRole(String roleUuid);
    
    /**
     * 保存资源对象
     * <p>Description:<p>
     * @param tabResource
     * @author guochun 2017-2-23
     */
    public void saveResource(TabResource tabResource);
    
    /**
     * 修改资源对象
     * <p>Description:<p>
     * @param tabResource
     * @author guochun 2017-2-23
     */
    public void updateResource(TabResource tabResource);
    
    /**
     * 获取资源菜单的最大ordernum+1
     * <p>Description:<p>
     * @return
     * @author guochun 2017-2-23
     */
    public Integer getTabResourceOrderNum();
    
    /**
     * 根据资源ID删除资源信息
     * @param resourceUuid
     */
    public void deleteResource(String resourceUuid);
    
    /**
     * 修改资源归属父资源
     * @param resourceUuid
     * @param parentResourceUuid
     */
    public void updateResourceTheParentUuid(String resourceUuid,String parentResourceUuid);
    /**
     * 修改资源名称
     * @param resourceUuid
     * @param newName
     */
    public void updateResourceTheName(String resourceUuid,String newName);
    
    /**
     * 根据资源Id查询资源
     * <p>Description:<p>
     * @param resourceUuid
     * @return
     * @author wenxiaoming 2017年7月5日
     */
    public Map<?,?> getTabResourceByUuid(String resourceUuid);
}
