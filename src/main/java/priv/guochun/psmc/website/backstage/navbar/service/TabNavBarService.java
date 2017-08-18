package priv.guochun.psmc.website.backstage.navbar.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;

/**
 * <p>Title: 获取网站导航栏的service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:18829012118@126.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年8月16日
 */
public interface TabNavBarService {
	/**
	 * <p>Description:获取前台显示的导航栏<p>
	 * @return
	 * @author wanglei 2017年8月16日
	 */
	public  List<TabNavBar> getAllShowTabNavBar();
	/**
	 * <p>Description:根据父导航栏菜单uuid获取前台显示的导航栏<p>
	 * @param parentMenuUuid 父导航栏id
	 * @return
	 * @author wanglei 2017年8月16日
	 */
	public  List<Map<String,Object>> getShowTabNavBarByParentMenuUuid(String parentMenuUuid);
}
