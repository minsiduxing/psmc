package priv.guochun.psmc.website.backstage.InfoRelease.service;

import java.sql.Timestamp;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoRelease;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

public interface InfoReleaseService {

	/**
	 * <p>Description:新增修改信息<p>
	 * @param InfoRelease  信息发布实体类
	 * @param tabModule
	 * @author wangtao 2018年5月14日
	 */
	public void saveOrUpdateInfoReleaseBusinessMethod (InfoRelease infoRelease, TabModule tabModule);
	/**
	 * <p>Description:根据id删除信息<p>
	 * @param uuids id
	 * @author  wangtao 2018年5月14日
	 */
	public void deleteInfoReleaseByUuidsBusinessMethod(String uuids);
	/**
	 * <p>Description:根据主键获取信息<p>
	 * @param uuid主键
	 * @return 
	 * @author  wangtao 2018年5月14日
	 */
	public Map<String,Object> getInfoReleaseByUuidBusinessMethod(String uuid);
	/**
	 * <p>Description:获取信息发布列表<p>
	 * @param myPage
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public MyPage getInfoReleaseListBusinessMethod(MyPage myPage);
	
	/**
	 * <p>Description:审核信息<p>
	 * @param 
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public void executeAuditModuleBusinessMethod(String newsIds, String userId);
	
	/**
	 * <p>Description:发布信息<p>
	 * @param 
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public void executeReleaseModuleBusinessMethod(String newsIds, String userId, Timestamp publishExpireDate);
	
	/**
	 * 查看信息详情 - mobile
	 * @param uuid
	 * @return
	 */
	public Map<String,Object> getInfoDetailToMobile(String uuid);
	
	/**
	 * 获取信息列表 - mobile
	 * @param mypage
	 * @return
	 */
	public MyPage queryInfoListToMobile(MyPage mypage);
	
}
