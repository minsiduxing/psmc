package priv.guochun.psmc.authentication.user.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabPerson;

public interface TabPersonDao 
{
    
    public Map getTabPersonByUuid(String uuid);
    
    public Map getTabPersonByAccountId(String id);
    
    public void deleteTabPersonsByAccUuids(String accUuids);
    
    public void saveOrUpdatePerson(TabPerson tabPerson);
    
    public List<Object> getTabPersonByGroupid(String groupid);
}
