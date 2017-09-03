package priv.guochun.psmc.website.backstage.modulepublish.dao;

import java.util.Map;

import priv.guochun.psmc.website.backstage.modulepublish.model.TabModulePublish;

/**
 * <p>Title: 模块发布类的数据接口</p>
 * <p>Description: 包括模块发布信息的新增、修改、删除、查询</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年9月3日
 */
public interface TabModulePublishDao {
	/**
	 * <p>Description:新增或者编辑模块发布信息<p>
	 * @param tmp 模块实体类
	 * @author wanglei 2017年9月3日
	 */
	public void saveOrUpdateTabModulePublish(TabModulePublish tmp);
	/**
	 * <p>Description: 根据主键删除模块发布信息<p>
	 * @param ids 模块ID
	 * @author wanglei 2017年9月3日
	 */
	public void deleteTabModulePublishByids(String ids);
	/**
	 * <p>Description: 根据ID获取模块发布的信息<p>
	 * @param id 模块发布信息id
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public Map<String,Object> getTabModulePublishByid(String id);
	
}
