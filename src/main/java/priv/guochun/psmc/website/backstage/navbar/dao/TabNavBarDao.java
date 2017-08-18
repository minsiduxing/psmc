package priv.guochun.psmc.website.backstage.navbar.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;

/**
 * <p>Title: 网站导航栏的dao</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:18829012118@126.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年8月16日
 */
public interface TabNavBarDao {
	/**
	 * <p>Description:导航栏的新增和编辑方法<p>
	 * @param tnav 导航栏类
	 * @author wanglei 2017年8月16日
	 */
	public void saveOrUpdateTabNavBar(TabNavBar tnav);
	/**
	 * <p>Description:根据导航栏主键删除导航栏<p>
	 * @param ids 导航栏主键
	 * @author wanglei 2017年8月16日
	 */
	public void deleteTabNavBarByMenuUuid(String  ids);
	/**
	 * <p>Description:获取前台显示的导航栏<p>
	 * @return
	 * @author wanglei 2017年8月16日
	 */
	public   List<TabNavBar> getAllShowTabNavBar();
	/**
	 * <p>Description:根据父导航栏菜单uuid获取前台显示的导航栏<p>
	 * @param parentMenuUuid 父导航栏id
	 * @return
	 * @author wanglei 2017年8月16日
	 */
	public  List<Map<String,Object>> getShowTabNavBarByParentMenuUuid(String parentMenuUuid);
}
