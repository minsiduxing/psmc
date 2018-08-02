package priv.guochun.psmc.authentication.role.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.role.model.TabRole;
import priv.guochun.psmc.system.framework.page.MyPage;

public interface TabRoleService {
	/**
	 * 根据uuid获取角色信息
	 * 
	 * @param uuid
	 * @return
	 */
	public Map<?, ?> getTableRoleByUuid(String role);

	/**
	 * 根据账号ID获取该账号的角色信息
	 * 
	 * @param accountId
	 * @return
	 */
	public Map<?, ?> getAccountUnionRoleByAccount(String accountId);

	/**
	 * @param mypage
	 * @return
	 * @Description: 根据获取角色列表
	 */
	public MyPage getRolesListBusinessMethod(MyPage mypage);
	/**
	 * 得到所有角色
	 * @param mypage
	 * @return
	 */
	public List<?> getAllRolesListBusinessMethod(MyPage mypage);
	
	/**
     * @param TabRole
     * @return
     * @Description: 获取全量角色列表
     */
    public List<Map<?, ?>> getAllPageRolesList(TabRole role);

	/**
	 * @param uuid
	 * @return
	 * @Description: 根据uuid获取角色所有信息
	 */
	public Map<?, ?> getTabRole(String uuid);

	/**
	 * 校验角色编号是否唯一
	 * <p>Description:<p>
	 * @param roleNo
	 * @param uuid
	 * @return
	 * @author guochun 2017-2-22
	 */
	public boolean executeRoleUniqueValidate(String roleNo, String uuid);

	/**
	 * 保存或者更新角色基本信息
	 * <p>Description:<p>
	 * @param role
	 * @return
	 * @author guochun 2017-2-22
	 */
	public boolean saveOrUpdateRoleBusinessMethod(TabRole role);

	/**
	 * 删除角色表数据，会级联删除：
	 * 1、删除角色和资源关联关系
	 * 2、删除角色和操作关联关系
	 * <p>Description:<p>
	 * @param uuids
	 * @return
	 * @author guochun 2016-12-15
	 */
	public boolean deletesRoleByUuidsBusinessMethod(String uuids);
	
	/**
	 * 根据账户id 删除账户和角色的关联关系
	 * <p>Description:<p>
	 * @param accUuids
	 * @return
	 * @author guochun 2016-12-15
	 */
	public boolean deletesAccRoleRelationByAccUuids(String accUuids);
	
	/**
	 * 保存账户和角色关联关系
	 * <p>Description:<p>
	 * @param accUuid
	 * @param roleUuids
	 * @return
	 * @author guochun 2016-12-15
	 */
	public boolean saveAccRoleRelationByAccUuids(String accUuid,String roleUuids);
	
}
