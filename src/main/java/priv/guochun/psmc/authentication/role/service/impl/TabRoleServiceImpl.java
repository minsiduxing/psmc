package priv.guochun.psmc.authentication.role.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.authentication.operate.dao.TabRoleOperateDao;
import priv.guochun.psmc.authentication.resource.dao.TabRoleResourceDao;
import priv.guochun.psmc.authentication.role.dao.TabRoleDao;
import priv.guochun.psmc.authentication.role.model.TabRole;
import priv.guochun.psmc.authentication.role.service.TabRoleService;
import priv.guochun.psmc.system.framework.page.MyPage;

public class TabRoleServiceImpl implements TabRoleService {

	private TabRoleDao tabRoleDao;
	
	private TabRoleResourceDao tabRoleResourceDao;
	
	private TabRoleOperateDao tabRoleOperateDao;

	@Override
	public Map<?, ?> getTableRoleByUuid(String uuid) {
		return tabRoleDao.getTableRoleByUuid(uuid);
	}

	@Override
	public Map<?, ?> getAccountUnionRoleByAccount(String accountId) {
		List<?> list = tabRoleDao.getAccountUnionRoleByAccount(accountId);
		if(list != null && list.size()>0){
			return (Map<?, ?>)list.get(0);
		}else
			return null;
	}


	@Override
	public MyPage getRolesListBusinessMethod(MyPage mypage) {
	    return this.tabRoleDao.getMyPageOfTabRoles(mypage);
	}

	public List<Map<?, ?>> getAllPageRolesList(TabRole role){
	    return this.tabRoleDao.getAllPageOfTabRoles(role);
	}
	
	@Override
	public Map<?, ?> getTabRole(String uuid) {
		
		if(StringUtils.isBlank(uuid))
    		return null;

		Map<?, ?> map =tabRoleDao.getTableRoleByUuid(uuid);
        return map;
	}
	
	@Override
    public boolean executeRoleUniqueValidate(String roleNo, String uuid){
         List<?> list = tabRoleDao.roleUniqueValidate(uuid, roleNo);
         if(list != null && list.size()>0){
             return false;
         }else
             return true;
    }

	@Override
	public boolean saveOrUpdateRoleBusinessMethod(TabRole role) {
	    tabRoleDao.saveOrUpdateTabRole(role);
	    return true;
	}
	
	@Override
	public boolean deletesRoleByUuidsBusinessMethod(String uuids) {
	    //加载角色和账户关联关系，判断角色是否可以删除
	    List<?> list = tabRoleDao.getAccountUnionRoleByRoleUuids(uuids);
        if(list !=null && list.size()>0){
            return false;
        }else{
            //删除角色和资源关联关系
            tabRoleResourceDao.deleteRoleResouceRelationByRoleUuids(uuids);
            //删除角色和操作关联关系
            tabRoleOperateDao.deleteRoleOperateRelationByRoleUuids(uuids);
            //删除角色
            tabRoleDao.deletesRoles(uuids);
            
            return true;
        }
	}

	
	@Override
    public boolean deletesAccRoleRelationByAccUuids(String accUuids)
    {
	    tabRoleDao.deletesAccountsRoleRelationsByAccountUuids(accUuids);
        return true;
    }
	
	public boolean saveAccRoleRelationByAccUuids(String accUuid,String roleUuids){
	    tabRoleDao.saveAccRoleRelations(accUuid, roleUuids);
	    return true;
	}

	public TabRoleDao getTabRoleDao() {
		return tabRoleDao;
	}

	public void setTabRoleDao(TabRoleDao tabRoleDao) {
		this.tabRoleDao = tabRoleDao;
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
    
    
}
