package priv.guochun.psmc.website.backstage.webuser.service;

import java.util.Map;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.webuser.model.TabWebUser;

public interface TabWebUserService {

	/**
	 * 获取网站用户列表
	 * @return
	 */
	public MyPage getWebUsersBusinessMethod(MyPage mapage);
	
	/**
	 * 判断用户是否存在
	 * @param userId
	 * @param password
	 * @return
	 */
	public int isVaild(String userId,String password);
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
	
	/**
	 * 保存或修改用户信息
	 * @param user
	 * @return
	 */
	public boolean saveOrUpdateBusinessMethod(TabWebUser user);
	
	/**
	 * 用户唯一校验
	 * @param user
	 * @return
	 */
	public boolean executeWebUserUniqueValidate(TabWebUser user);
	
	/**
	 * 批量删除用户
	 * @param uuids
	 * @return
	 */
	public boolean deleteWebUsersBusinessMethod(String uuids);
}
