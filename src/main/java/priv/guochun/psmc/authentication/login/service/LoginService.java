package priv.guochun.psmc.authentication.login.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.login.model.User;

public interface LoginService
{
    /**
     * 校验账号密码是否存在
     * <p>Description:<p>
     * @param username
     * @param password
     * @return 如果存在,则返回"success",否则,返回错误提示
     * @author guochun 2016-8-19
     */
    public String isVaild(String username,String password);
    
    /**
     * 构建登录对象，主要构建该账号人员信息、角色信息、权限信息
     * <p>Description:<p>
     * @param user
     * @return
     * @author guochun 2016-8-19
     */
    public User buildUser(String username);
    
    /**
     * 获取某一个角色的系统导航栏资源菜单信息
     * <p>Description:<p>
     * @param role
     * @return
     * @author guochun 2016-8-19
     */
    public List<Map<?,?>> getNavigationBarResourcesByRoleUuid(String roleUuid);
    
    
    /**
     * 得到某一个角色下的的某一个资源
     * @param resourceId
     * @param roleUuid
     * @return
     */
    public Map getResource (String resourceId,String roleUuid);
    
    
    /**
     * 在某一个角色下获取某一个资源的下一级资源
     * @param moduleId
     * @param roleUuid
     * @param ContainSelf 是否包含自身
     * @return
     */
    
    public List<Map<?,?>> getSubResources(String resourceId,String roleUuid,boolean ContainSelf );
    
}
