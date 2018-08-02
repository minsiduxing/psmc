package priv.guochun.psmc.authentication.user.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.authentication.role.service.TabRoleService;
import priv.guochun.psmc.authentication.user.dao.TabAccountDao;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.system.framework.page.MyPage;


public class TabAccountServiceImpl implements TabAccountService
{
	private TabAccountDao tabAccountDao;
	
	private TabPersonService tabPersonService;
	
	private TabRoleService tabRoleService;
	
    @Override
    public Map getTabAccount(String username, String password)
    {
    	Map map = null;
    	try{
    		map =tabAccountDao.getTabAccount(username, password);
    	}catch(Exception e){
    		map = null;
    		e.printStackTrace();
    	}
        return map;
    }

    @Override
    public Map getTabAccount(String uuid)
    {
    	if(StringUtils.isBlank(uuid))
    		return null;
        return tabAccountDao.getTabAccount(uuid);
    }

	@Override
	public MyPage getTabAccountsBusinessMethod(MyPage myPage){
		return tabAccountDao.getMyPageOfTabAccounts(myPage);
	}
	
	@Override
	public List<?> getAllTabAccountsBusinessMethod(MyPage myPage){
		//设置查询全部
		myPage.setPageIndex(-1);
		MyPage page = tabAccountDao.getMyPageOfTabAccounts(myPage);
		return page.getDataList();
	}
	
	 public boolean executeAccountUniqueValidate(String accountName,String accountUUid){
		 List list = tabAccountDao.accountUniqueValidate(accountName, accountUUid);
		 if(list != null && list.size()>0){
			 return false;
		 }else
			 return true;
	 }
	 
	 public boolean saveOrUpdateBusinessMethod(TabAccount account,TabPerson person,String role_ids){
		 return this.register(account,person,role_ids);
	 }
    
	 public boolean register(TabAccount account,TabPerson person,String role_ids){
		 tabAccountDao.saveOrUpdateAccount(account);
		 tabPersonService.saveOrUpdate(person);
		 tabRoleService.deletesAccRoleRelationByAccUuids(account.getUuid());
		 tabRoleService.saveAccRoleRelationByAccUuids(account.getUuid(), role_ids);
		 return true;
	 }
	
	@Override
	public boolean deletesBusinessMethod(String uuids) {
			tabRoleService.deletesAccRoleRelationByAccUuids(uuids);
			tabPersonService.deleteTabPersonsByAccUuids(uuids);
			tabAccountDao.deletesAccounts(uuids);
			return true;
	}

	public TabAccountDao getTabAccountDao() {
		return tabAccountDao;
	}

	public void setTabAccountDao(TabAccountDao tabAccountDao) {
		this.tabAccountDao = tabAccountDao;
	}

	public TabPersonService getTabPersonService() {
		return tabPersonService;
	}

	public void setTabPersonService(TabPersonService tabPersonService) {
		this.tabPersonService = tabPersonService;
	}

    public TabRoleService getTabRoleService()
    {
        return tabRoleService;
    }

    public void setTabRoleService(TabRoleService tabRoleService)
    {
        this.tabRoleService = tabRoleService;
    }

	@Override
	public boolean updateAccountPasswdMethod(TabAccount tabAccount) {
		tabAccountDao.saveOrUpdateAccount(tabAccount);
		return true;
	}
	
}	
