package priv.guochun.psmc.authentication.operate.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.authentication.operate.dao.TabOperateDao;
import priv.guochun.psmc.authentication.operate.dao.TabRoleOperateDao;
import priv.guochun.psmc.authentication.operate.model.TabOperate;
import priv.guochun.psmc.authentication.operate.service.TabOperateService;
import priv.guochun.psmc.system.util.UUIDGenerator;

public class TabOperateServiceImpl implements TabOperateService {
	
	private TabOperateDao tabOperateDao;
	
	private TabRoleOperateDao tabRoleOperateDao;
	
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
	
	@Override
    public Integer getTabOperateOrderNum()
    {
	    return tabOperateDao.getTabOperateOrderNum();
    }
	
    @Override
    public List getTabOperatesByResourceUuid(String resourceuuid)
    {
        return tabOperateDao.getTabOperatesByResourceUuid(resourceuuid);
    }
    
    @Override
    public void saveOrUpdateResOperateConfig(TabOperate tabResourceOperate)
    {
        if (StringUtils.isNotBlank(tabResourceOperate.getUuid())){
            tabOperateDao.updateResOperateConfig(tabResourceOperate);
        }else{
            String uuid = UUIDGenerator.createUUID();
            tabResourceOperate.setUuid(uuid);
            tabOperateDao.saveResOperateConfig(tabResourceOperate);
        }
    }

    @Override
    public int selectRoleCountByOperate(String operateUuid)
    {
        int count = tabRoleOperateDao.selectRoleCountByOperate(operateUuid);
        return count;
    }

    @Override
    public int deleteOperate(String operateUuid)
    {
        int count = tabOperateDao.deleteOperate(operateUuid);
        return count;
    }
	
	public TabOperateDao getTabOperateDao() {
		return tabOperateDao;
	}

	public void setTabOperateDao(TabOperateDao tabOperateDao) {
		this.tabOperateDao = tabOperateDao;
	}
	
    public TabRoleOperateDao getTabRoleOperateDao()
    {
        return tabRoleOperateDao;
    }
    public void setTabRoleOperateDao(TabRoleOperateDao tabRoleOperateDao)
    {
        this.tabRoleOperateDao = tabRoleOperateDao;
    }
}
