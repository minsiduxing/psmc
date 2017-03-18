package priv.guochun.psmc.authentication.operate.service.impl;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.operate.dao.TabOperateDao;
import priv.guochun.psmc.authentication.operate.service.TabOperateService;

public class TabOperateServiceImpl implements TabOperateService {
	
	private TabOperateDao tabOperateDao;
	@Override
	public List<Map<?,?>> getPermitOperatesByRoleUuid(String role_uuid) {
		return tabOperateDao.getPermitOperatesByRoleUuid(role_uuid);
	}

	@Override
	public List getTabOperatesByRoleUuidAndResourceUuid(String role_uuid,
			String resource_uuid) {
		return tabOperateDao.getTabOperates(role_uuid, resource_uuid);
	}
	
	@Override
	public boolean deleteTabOperatesByResourceUuid(String resourceUuid){
		tabOperateDao.deleteTabOperatesByResourceUuid(resourceUuid);
		return true;
	}
	
	
	public TabOperateDao getTabOperateDao() {
		return tabOperateDao;
	}

	public void setTabOperateDao(TabOperateDao tabOperateDao) {
		this.tabOperateDao = tabOperateDao;
	}

	
	
}
