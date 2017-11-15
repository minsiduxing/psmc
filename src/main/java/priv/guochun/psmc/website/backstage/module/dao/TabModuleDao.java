package priv.guochun.psmc.website.backstage.module.dao;

import java.util.List;

import priv.guochun.psmc.website.backstage.module.model.TabModule;

/**
 * <p>Title: 模块的Dao接口</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年9月3日
 */
public interface TabModuleDao {
	/**
	 * <p>Description:添加或者修改模块<p>
	 * @param tam 模块类
	 * @author wanglei 2017年9月3日
	 */
	public void saveOrUpdateTabModule(TabModule tam);
	/**
	 * <p>Description:发布模块<p>
	 * @param uuid模块id
	 * @param tam 模块实体类
	 * @author wanglei 2017年11月15日
	 */
	public void excuteAudiTabModules(String ids ,TabModule tam);
	/**
	 * <p>Description:模块发布<p>
	 * @param ids模块ID
	 * @param tam 模块实体类
	 * @author wanglei 2017年11月15日
	 */
	public void excuteReleaseTabModules(String ids ,TabModule tam);
	/**
	 * <p>Description:删除模块<p>
	 * @param ids 模块id
	 * @author wanglei 2017年9月3日
	 */
	public void deleteTabModule(String ids);
	/**
	 * <p>Description:根据id查询模块<p>
	 * @param id 模块id
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public TabModule getModuleByUuid(String id);
	/**
	 * <p>Description:根据多个id获取模块<p>
	 * @param ids
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public List<TabModule>getModulesByUuids(String ids);
}
