package priv.guochun.psmc.website.backstage.webuser.service.impl;

import org.springframework.stereotype.Service;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.webuser.dao.TabWebUserDao;
import priv.guochun.psmc.website.backstage.webuser.service.TabWebUserService;

@Service
public class TabWebUserServiceImpl implements TabWebUserService {

	@Override
	public MyPage getWebUserList(MyPage mapage) {
		return tabWebUserDao.getWebUserList(mapage);
	}
	
	@Override
	public int isVaild(String userId, String password) {
		return tabWebUserDao.queryUserCount(userId, password);
	}
	
	private TabWebUserDao tabWebUserDao;

	public void setTabWebUserDao(TabWebUserDao tabWebUserDao) {
		this.tabWebUserDao = tabWebUserDao;
	}
}
