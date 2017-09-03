package priv.guochun.psmc.website.backstage.module.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.module.dao.TabModuleDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;

public class TabModuleServiceImpl implements TabModuleService {
	protected static final  Logger logger  = LoggerFactory.getLogger(TabModuleService.class);
	@Autowired
	private TabModuleDao tabModuleDao;
	@Override
	public void saveOrupdateTabmodule(TabModule tam) {
		tabModuleDao.saveOrUpdateTabModule(tam);
	}

	@Override
	public void deleteTabModulebyUuids(String ids) {
		tabModuleDao.deleteTabModule(ids);
	}

	@Override
	public void auditModule(TabModule tm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseModule(TabModule tm) {
		// TODO Auto-generated method stub
		
	}

}
