package priv.guochun.psmc.authentication.user.dao;

import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabPerson;

public interface TabPersonDao 
{
    
    public Map getTabPersonByUuid(String uuid);
    
    public Map getTabPersonByAccountId(String id);
    
    public void deleteTabPersonsByAccUuids(String accUuids);
    
    public void saveOrUpdatePerson(TabPerson tabPerson);
}
