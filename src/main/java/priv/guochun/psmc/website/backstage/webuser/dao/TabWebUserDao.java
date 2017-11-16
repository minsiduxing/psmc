package priv.guochun.psmc.website.backstage.webuser.dao;

import priv.guochun.psmc.system.framework.page.MyPage;

public interface TabWebUserDao {

	/**
	 * 获取网站用户列表
	 * @return
	 */
	public MyPage getWebUserList(MyPage mapage);
	
	/**
	 * 判断用户是否存在
	 * @param userId
	 * @param password
	 * @return
	 */
	public int queryUserCount(String userId, String password);
}
