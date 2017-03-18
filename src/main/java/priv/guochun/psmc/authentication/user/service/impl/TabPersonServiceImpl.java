package priv.guochun.psmc.authentication.user.service.impl;

import java.util.Map;

import priv.guochun.psmc.authentication.user.dao.TabPersonDao;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabPersonService;


public class TabPersonServiceImpl implements TabPersonService
{
    
    private TabPersonDao tabPersonDao;
    
    @Override
    public Map getTabPersonByAccountId(String accountsId)
    {
        return tabPersonDao.getTabPersonByAccountId(accountsId);
    }

    @Override
    public Map getTabPersonById(String uuid)
    {
        return tabPersonDao.getTabPersonByUuid(uuid);
    }
    
    @Override
    public boolean saveOrUpdate(TabPerson tabPerson){
    	tabPersonDao.saveOrUpdatePerson(tabPerson);
    	return true;
    }
    
    @Override
    public boolean deleteTabPersonsByAccUuids(String accUuids){
    	tabPersonDao.deleteTabPersonsByAccUuids(accUuids);
    	return true;
    }
    
    

	public TabPersonDao getTabPersonDao() {
		return tabPersonDao;
	}

	public void setTabPersonDao(TabPersonDao tabPersonDao) {
		this.tabPersonDao = tabPersonDao;
	}
    
   
}
