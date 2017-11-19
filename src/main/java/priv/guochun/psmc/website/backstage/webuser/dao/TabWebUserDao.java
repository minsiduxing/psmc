package priv.guochun.psmc.website.backstage.webuser.dao;

import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.webuser.model.TabWebUser;

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
	
	/**
	 * <p>Description:根据用户id查询用户信息<p>
	 * @param twu 用户实体类
	 * @return
	 * @author wanglei 2017年11月19日
	 */
	public Map<String,Object> findUserByCondition(TabWebUser twu);
	/**
	 * <p>Description:更新用户信息<p>
	 * @param twu 用户信息
	 * @author wanglei 2017年11月19日
	 */
	public void updateUser (TabWebUser twu);
}
