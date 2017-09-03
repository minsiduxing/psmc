package priv.guochun.psmc.website.backstage.modulepublish.service;

import java.util.List;

import priv.guochun.psmc.website.backstage.modulepublish.model.TabModulePublish;

public interface TabModulePublishService {
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
	 * <p>Description:根据模块id删除发布信息<p>
	 * @param mids 模块id
	 * @author wanglei 2017年9月3日
	 */
	public void deleteTabModulePublishByModuleids(String mids);
	/**
	 * <p>Description: 根据ID获取模块发布的信息<p>
	 * @param id 模块发布信息id
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public TabModulePublish getTabModulePublishByid(String id);
	/**
	 * <p>Description:根据模块id获取发布信息<p>
	 * @param ids 模块id
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public List<TabModulePublish> getTabModulePublishsByModuleids(String ids);
}
