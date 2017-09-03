package priv.guochun.psmc.website.backstage.module.dao;

import java.util.Map;

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
	public Map<String,Object>getModuleByUuid(String id);
}
