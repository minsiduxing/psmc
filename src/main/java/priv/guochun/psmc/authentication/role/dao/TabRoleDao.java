package priv.guochun.psmc.authentication.role.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.role.model.TabRole;
import priv.guochun.psmc.system.framework.page.MyPage;

public interface TabRoleDao  {
	
	/**
	 * 根据uuid获取角色信息
	 * @param uuid
	 * @return
	 */
	public Map<?, ?> getTableRoleByUuid(String uuid);
	
	/**
	 * 根据账号ID获取该账号所有的角色信息
	 * @param accountId
	 * @return
	 */
	public List<?> getAccountUnionRoleByAccount(String accountId);
	
	/**
     * 根据角色ID获取该角色和所有账户关联的信息
     * @param accountId
     * @return
     */
    public List<?> getAccountUnionRoleByRoleUuids(String roleUuids);

	/**
	 * 获取角色分页信息
	 * <p>Description:<p>
	 * @param myPage
	 * @return
	 * @author guochun 2016-9-30
	 */
	
	public MyPage getMyPageOfTabRoles(MyPage myPage);
	
	/**
	 * 获取全量角色列表
	 * <p>Description:<p>
	 * @param tabRole
	 * @return
	 * @author guochun 2016-12-13
	 */
	public List<Map<?, ?>> getAllPageOfTabRoles(TabRole tabRole);
	
	public void saveOrUpdateTabRole(TabRole tabRole);

	public List<?> roleUniqueValidate(String uuid, String roleno);

	/**
	 * 根据主键删除角色表数据，同时级联删除角色和账户关联关系。
	 * <p>Description:<p>
	 * @param uuids
	 * @author guochun 2016-12-15
	 */
	public void deletesRoles(String uuids);
	
	/**
     * 根据accUuids删除多个账户和角色的所有关联关系
     * <p>Description:<p>
     * @param uuids
     * @author guochun 2016-12-15
     */
    public void deletesAccountsRoleRelationsByAccountUuids(String accountUuids);
    
    /**
     * 根据roleUuids删除多个账户和角色的所有关联关系
     * <p>Description:<p>
     * @param uuids
     * @author guochun 2016-12-15
     */
    public void deletesAccountsRoleRelationsByRoleUuids(String roleUuids);
    
    
    /**
     * 保存账户和角色关联关系
     * <p>Description:<p>
     * @param accUuid
     * @param roleUuids
     * @author guochun 2016-12-15
     */
    public void saveAccRoleRelations(String accUuid,String roleUuids);
	
	

}
