package priv.guochun.psmc.website.stage.navbar.service;

import java.util.Map;

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
	public Map getAllShowTabNavBarBusinessMethod();
	/**
	 * <p>Description:根据父导航栏菜单uuid获取前台显示的导航栏<p>
	 * @param parentMenuUuid 父导航栏id
	 * @return
	 * @author wanglei 2017年8月16日
	 */
	public Map getShowTabNavBarByParentMenuUuidBusinessMethod(String parentMenuUuid);
}
