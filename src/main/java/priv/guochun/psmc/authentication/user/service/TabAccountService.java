package priv.guochun.psmc.authentication.user.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.system.framework.page.MyPage;


public interface TabAccountService
{
    /**
     * 根据用户名/密码获取账户信息
     * <p>Description:<p>
     * @param username
     * @param password
     * @return
     * @author guochun 2016-8-19
     */
    public Map getTabAccount(String username,String password);
    
    /**
     * 根据主键UUID获取账号信息
     * <p>Description:<p>
     * @param uuid
     * @return
     * @author guochun 2016-8-19
     */
    public Map getTabAccount(String uuid);
    
    /**
     * 得到分页的用户列表，包括账号信息和用户信息
     * @return
     */
    public MyPage getTabAccountsBusinessMethod(MyPage myPage);
    /**
     * 得到全部用户列表
     * @param myPage
     * @return
     */
    public List<?> getAllTabAccountsBusinessMethod(MyPage myPage);
    
    /**
     * 账号是否唯一 
     * @param accountName
     * @param accountUUid 如果accountUUid不为空,则将accountUUid这条数据排除在校验范围外
     * @return
     */
    
    public boolean executeAccountUniqueValidate(String accountName,String accountUUid);
    
    /**
     * 保存、更新账户信息,级联操作账户、用户、用户所属角色等信息
     * @param account
     * @param person
     * @param role_ids
     * @return
     */
    public boolean saveOrUpdateBusinessMethod(TabAccount account,TabPerson person,String role_ids);
    
    public boolean register(TabAccount account,TabPerson person,String role_ids);
    
    /**
     * 批量删除账户信息,级联删除账户、用户、用户所属角色等信息
     * @param uuids
     * @return
     */
    public boolean deletesBusinessMethod(String uuids);
    
    /**
     * 修改账户密码
     * @param uuid
     * @param newPassword
     * @return
     * @author yangqing 2017-4-9
     */
    public boolean updateAccountPasswdMethod(TabAccount tabAccount);
}
