package priv.guochun.psmc.authentication.user.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.system.framework.page.MyPage;

public interface TabAccountDao 
{
    /**
     * 得到账号信息ById
     * <p>Description:<p>
     * @param id
     * @return
     * @author guochun 2016-8-19
     */
    public Map getTabAccount(String id);
    /**
     * 根据手机号+账户类型获取一条账户信息
     * @param phone
     * @param accountType
     * @return
     */
    public Map getTabAccountByPhone(String phone,int accountType);
    
    public Map getTabAccount(String username,String password);
    
    public List accountUniqueValidate(String username,String accountUuid);
    
    public MyPage getMyPageOfTabAccounts(MyPage myPage);
    
    public void deletesAccounts(String ids);
    
    public void saveOrUpdateAccount(TabAccount tabAccount);
}
