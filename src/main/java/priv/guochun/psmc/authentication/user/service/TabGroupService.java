package priv.guochun.psmc.authentication.user.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabGroup;
import priv.guochun.psmc.system.framework.model.MsgModel;

public interface TabGroupService
{
    /**
     * 得到用户组总数
     * @return
     */
	public int getTabGroupCount();
	
    /**
     * 得到系统所有组织机构对象 主要用于组织机构资源树展示
     * @return
     */
    public List<Map<?,?>> getTabGroupsBusinessMethod();
    
    /**
     * 获取一条组织机构信息
     * @param groupCode
     * @return
     */
    public TabGroup getTabGroupsByGroupCode(String groupCode);
    
    /**
     * 根据groupCode等到子组织
     * @param parentGroupCode
     * @return
     */
    public List<TabGroup> getSubTabGroupsByGroupCode(String groupCode);
    
    /**
     * 更新当前组的所属上级组
     * @param groupCode
     * @param parentGroupCode
     * @return
     */
    public MsgModel updateParentGroupCodeBusinessMethod(String groupCode,String parentGroupCode);
    
    
    /**
     * 新增
     * @param tabGroup
     * @return
     */
    public MsgModel saveTabGroupBusinessMethod(TabGroup tabGroup);
    
    /**
     * 修改
     * @param tabGroup
     * @return
     */
    public MsgModel updateTabGroupBusinessMethod(TabGroup tabGroup);
    
    /**
     * 删除
     * @param tabGroup
     * @return
     */
    public MsgModel deleteTabGroupBusinessMethod(TabGroup tabGroup);
    
    
}
