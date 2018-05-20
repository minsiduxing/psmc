package priv.guochun.psmc.website.backstage.InfoRelease.dao;

import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoRelease;

public interface InfoReleaseDao {
	
	/**
	 * <p>Description:新增修改信息<p>
	 * @param InfoRelease  信息发布实体类
	 * @author wangtao 2018年5月14日
	 */
	public void saveOrUpdateInfoRelease (InfoRelease infoRelease);
	/**
	 * <p>Description:根据id删除信息<p>
	 * @param uuids id
	 * @author  wangtao 2018年5月14日
	 */
	public void deleteInfoReleaseByUuids(String uuids);
	/**
	 * <p>Description:根据主键获取信息<p>
	 * @param uuid主键
	 * @return 
	 * @author  wangtao 2018年5月14日
	 */
	public Map<String,Object> getInfoReleaseByUuid(String uuid);
	/**
	 * <p>Description:获取信息发布列表<p>
	 * @param myPage
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public MyPage getInfoReleaseList(MyPage myPage);
}
