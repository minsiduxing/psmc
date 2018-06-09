package priv.guochun.psmc.authentication.user.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.user.model.TabGroup;

public interface TabGroupDao 
{
	
	public int getTabGroupCount();
	
    /**
     * 新增/修改 用户组
     * @param tabGroup
     */
    public int saveOrUpdateTabGroup(TabGroup tabGroup);
    
    /**
     * 删除组
     * @return
     */
    public int deleteTabGroup(String uuid);
    
    /**
     * 得到所有组织机构
     * @return
     */
    public List<Map<?, ?>> getAllTabGroups();
    
    /**
     * 根据groupCode获取一条组织机构
     * @param condition
     * @return
     */
    public TabGroup getTabGroupsBygroupCode(String groupCode);
    
    /**
     * 得到某一个组织的子组织
     * @param groupCode
     * @return
     */
    public List<TabGroup> getSubTabGroupsByGroupCode(String groupCode);

}
