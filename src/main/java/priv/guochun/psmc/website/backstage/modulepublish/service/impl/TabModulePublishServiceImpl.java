package priv.guochun.psmc.website.backstage.modulepublish.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.modulepublish.dao.TabModulePublishDao;
import priv.guochun.psmc.website.backstage.modulepublish.model.TabModulePublish;
import priv.guochun.psmc.website.backstage.modulepublish.service.TabModulePublishService;

public class TabModulePublishServiceImpl implements TabModulePublishService {
	protected static final  Logger logger  = LoggerFactory.getLogger(TabModulePublishServiceImpl.class);
	@Autowired
	private TabModulePublishDao tabModulePublishdao;
	@Override
	public void saveOrUpdateTabModulePublish(TabModulePublish tmp) {
		tabModulePublishdao.saveOrUpdateTabModulePublish(tmp);
	}

	@Override
	public void deleteTabModulePublishByids(String ids) {
		tabModulePublishdao.deleteTabModulePublishByids(ids);
	}

	@Override
	public Map<String, Object> getTabModulePublishByid(String id) {
		return tabModulePublishdao.getTabModulePublishByid(id);
	}

}
