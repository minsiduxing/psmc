package priv.guochun.psmc.website.backstage.navbar.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.guochun.psmc.website.backstage.navbar.dao.TabNavBarDao;
import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;
import priv.guochun.psmc.website.backstage.navbar.service.TabNavBarService;
public class TabNavBarServiceImpl implements TabNavBarService {
	private TabNavBarDao tabNavBarDao;
	@Override
	public   List<TabNavBar>  getAllShowTabNavBar() {
		return tabNavBarDao.getAllShowTabNavBar();
	}

	@Override
	public  List<Map<String,Object>> getShowTabNavBarByParentMenuUuid(String parentMenuUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	public TabNavBarDao getTabNavBarDao() {
		return tabNavBarDao;
	}

	public void setTabNavBarDao(TabNavBarDao tabNavBarDao) {
		this.tabNavBarDao = tabNavBarDao;
	}
	
}
 