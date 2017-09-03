package priv.guochun.psmc.website.backstage.module.service;

import priv.guochun.psmc.website.backstage.module.model.TabModule;


/**
 * <p>Title:模块的service </p>
 * <p>Description: 包含对模块 新增、修改、删除</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年9月3日
 */
public interface TabModuleService {
	/**
	 * <p>Description:新增和修改模块<p>
	 * @param tam 模块的实体类
	 * @author wanglei 2017年9月3日
	 */
	public void saveOrupdateTabmodule(TabModule tam);
	/**
	 * <p>Description:根据id批量删除模块<p>
	 * @param ids 模块的id
	 * @author wanglei 2017年9月3日
	 */
	public void deleteTabModulebyUuids(String ids);
	/**
	 * <p>Description:审核模块<p>
	 * @param tm 模块信息
	 * @author wanglei 2017年9月3日
	 */
	public void auditModule(TabModule tm);
	/**
	 * <p>Description:发布模块信息<p>
	 * @param tm 模块信息
	 * @author wanglei 2017年9月3日
	 */
	public void releaseModule(TabModule tm);
	/**
	 * <p>Description:取消模块发布<p>
	 * @author wanglei 2017年9月3日
	 */
	public void releaseCancel(TabModule tm);
	
}
