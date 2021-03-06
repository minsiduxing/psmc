package priv.guochun.psmc.authentication.user.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.user.dao.TabGroupDao;
import priv.guochun.psmc.authentication.user.model.TabGroup;
import priv.guochun.psmc.authentication.user.service.TabGroupService;
import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.system.framework.model.MsgModel;

public class TabGroupServiceImpl implements TabGroupService
{
    protected static final  Logger logger  = LoggerFactory.getLogger(TabGroupServiceImpl.class);

    private TabGroupDao tabGroupDao;
    
    @Autowired
    private TabPersonService tabPersonService;

    @Override
    public int getTabGroupCount(){
    	return tabGroupDao.getTabGroupCount();
    }
    
	@Override
	public List<Map<?, ?>> getTabGroupsBusinessMethod() {
		return tabGroupDao.getAllTabGroups();
	}

	@Override
	public TabGroup getTabGroupsByGroupCode(String groupCode) {
		return tabGroupDao.getTabGroupsBygroupCode(groupCode);
	}
	
	@Override
	public List<TabGroup> getSubTabGroupsByGroupCode(String groupCode){
		return tabGroupDao.getSubTabGroupsByGroupCode(groupCode);
	}

	@Override
	public MsgModel updateParentGroupCodeBusinessMethod(String groupCode,String parentGroupCode){
		TabGroup tabGroup = tabGroupDao.getTabGroupsBygroupCode(groupCode);
		TabGroup parenttabGroup = tabGroupDao.getTabGroupsBygroupCode(parentGroupCode);
		if(parenttabGroup != null && !parenttabGroup.getGroupCode().equals(tabGroup.getParentGroupCode()))
		tabGroup.setParentGroupCode(parenttabGroup.getGroupCode());
		int flag = tabGroupDao.saveOrUpdateTabGroup(tabGroup);
		if(flag>0)
			return MsgModel.buildDefaultSuccess(tabGroup);;
		
			return MsgModel.buildDefaultError();
	}

	@Override
	public MsgModel saveTabGroupBusinessMethod(TabGroup tabGroup) {
		TabGroup group = this.getTabGroupsByGroupCode(tabGroup.getGroupCode());
		if(group != null){
			return MsgModel.buildDefaultError("该用户组编码已经存在");
		}
		int flag = tabGroupDao.saveOrUpdateTabGroup(tabGroup);
		if(flag>0)
			return MsgModel.buildDefaultSuccess(tabGroup);
		
			return MsgModel.buildDefaultError();
	}

	@Override
	public MsgModel updateTabGroupBusinessMethod(TabGroup tabGroup) {
		int flag = tabGroupDao.saveOrUpdateTabGroup(tabGroup);
		if(flag>0)
			return MsgModel.buildDefaultSuccess(tabGroup);
		
			return MsgModel.buildDefaultError();
	}

	@Override
	public MsgModel deleteTabGroupBusinessMethod(TabGroup tabGroup) {
		List<Object> list = tabPersonService.getTabPersonByGroupid(tabGroup.getGroupCode());
		if(list != null && list.size() > 0){
			return MsgModel.buildDefaultError("该用户组下存在有用户，不能删除");
		}
		int flag = tabGroupDao.deleteTabGroup(tabGroup.getUuid());
		if(flag>0)
			return MsgModel.buildDefaultSuccess(null);
		
			return MsgModel.buildDefaultError();
	}

	public TabGroupDao getTabGroupDao() {
		return tabGroupDao;
	}

	public void setTabGroupDao(TabGroupDao tabGroupDao) {
		this.tabGroupDao = tabGroupDao;
	}

    
}
