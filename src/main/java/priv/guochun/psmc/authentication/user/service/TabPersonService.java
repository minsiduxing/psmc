package priv.guochun.psmc.authentication.user.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabPerson;


public interface TabPersonService
{
    /**
     * 通过账户UUID获取人员信息
     * <p>Description:<p>
     * @param accountsId
     * @return
     * @author guochun 2016-8-19
     */
    public Map getTabPersonByAccountId(String accountsId);
    
    /**
     * 通过主键获取人员信息
     * <p>Description:<p>
     * @param uuid
     * @return
     * @author guochun 2016-8-19
     */
    public Map getTabPersonById(String uuid);
    
    public boolean saveOrUpdate(TabPerson tabPerson);
    
    public boolean deleteTabPersonsByAccUuids(String accUuids);
    
    public List<Object> getTabPersonByGroupid(String groupid);
}
