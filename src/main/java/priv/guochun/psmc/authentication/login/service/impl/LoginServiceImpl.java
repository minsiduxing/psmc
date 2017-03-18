package priv.guochun.psmc.authentication.login.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.operate.dao.TabOperateDao;
import priv.guochun.psmc.authentication.resource.dao.TabResourceDao;
import priv.guochun.psmc.authentication.role.dao.TabRoleDao;
import priv.guochun.psmc.authentication.user.dao.TabAccountDao;
import priv.guochun.psmc.authentication.user.dao.TabPersonDao;
import priv.guochun.psmc.system.framework.util.ResourceEnum;

public class LoginServiceImpl implements LoginService
{
    protected static final  Logger logger  = LoggerFactory.getLogger(LoginServiceImpl.class);
    
    private TabAccountDao tabAccountDao;
    private TabPersonDao tabPersonDao;
    private TabRoleDao tabRoleDao;
    private TabOperateDao tabOperateDao;
    private TabResourceDao tabResourceDao;
    
    @Override
    public String isVaild(String username, String password)
    {
        String returnValue = "success";
        Map accMap = tabAccountDao.getTabAccount(username, password);
        if(accMap == null){
            returnValue="账号或密码在系统中不存在!";
            return returnValue;
        }
        Object lockEdObj = accMap.get("is_locked");
        if(lockEdObj != null && "是".equals(lockEdObj.toString())){
            returnValue="账号被锁定,请联系管理员!";
            return returnValue;
        }
        return returnValue;
    }

    @Override
    public User buildUser(String username)
    {
        logger.debug("username "+username+" buildUser start");
    	Map accountMap = tabAccountDao.getTabAccount(username, null);
    	String accountId = accountMap.get("UUID").toString();
    	Map personMap = tabPersonDao.getTabPersonByAccountId(accountId);
    	List accRoleLits = tabRoleDao.getAccountUnionRoleByAccount(accountId);
    	Map accRoleMap = (Map<?, ?>)accRoleLits.get(0);
    	String roleUuid = accRoleMap.get("UUID").toString();
    	Map roleMap = tabRoleDao.getTableRoleByUuid(roleUuid);
    	List operrateMap = tabOperateDao.getPermitOperatesByRoleUuid(roleUuid);
    	User user = new User(accountMap,personMap,roleMap,operrateMap);
    	logger.debug("username "+username+" buildUser end");
    	return user;
    }
    
    @Override
    public List<Map<?,?>> getNavigationBarResourcesByRoleUuid(String roleUuid)
    {
        if(StringUtils.isBlank(roleUuid)){
            logger.warn("roleUuid 为空,无法查询资源信息.....");
            return null;
        }
        return tabResourceDao.getSubResourcesByResourceId(
                String.valueOf(ResourceEnum.PsmcRootId.getUuid()), 
                ResourceEnum.ResourceType1.getIndex(), false,roleUuid);
    }
    @Override
    public Map getResource (String resourceId,String roleUuid){
     if(StringUtils.isBlank(resourceId) || StringUtils.isBlank(resourceId)){
            logger.warn("moduleId 或roleUuid为空,无法查询资源信息.....");
            return null;
        }
        return tabResourceDao.getResource(resourceId, null, roleUuid);
    }
    
    @Override
    public List<Map<?,?>> getSubResources(String resourceId,String roleUuid,boolean ContainSelf ){
     if(StringUtils.isBlank(resourceId) || StringUtils.isBlank(roleUuid)){
            logger.warn("resourceId 或roleUuid为空,无法查询资源信息.....");
            return null;
        }
        return tabResourceDao.getSubResourcesByResourceId
            (resourceId, null, ContainSelf, roleUuid);
    }
    
    

    public TabAccountDao getTabAccountDao()
    {
        return tabAccountDao;
    }

    public void setTabAccountDao(TabAccountDao tabAccountDao)
    {
        this.tabAccountDao = tabAccountDao;
    }

    public TabPersonDao getTabPersonDao()
    {
        return tabPersonDao;
    }

    public void setTabPersonDao(TabPersonDao tabPersonDao)
    {
        this.tabPersonDao = tabPersonDao;
    }

    public TabRoleDao getTabRoleDao()
    {
        return tabRoleDao;
    }

    public void setTabRoleDao(TabRoleDao tabRoleDao)
    {
        this.tabRoleDao = tabRoleDao;
    }

    public TabOperateDao getTabOperateDao()
    {
        return tabOperateDao;
    }

    public void setTabOperateDao(TabOperateDao tabOperateDao)
    {
        this.tabOperateDao = tabOperateDao;
    }

    public TabResourceDao getTabResourceDao()
    {
        return tabResourceDao;
    }

    public void setTabResourceDao(TabResourceDao tabResourceDao)
    {
        this.tabResourceDao = tabResourceDao;
    }

    


    
    
}
