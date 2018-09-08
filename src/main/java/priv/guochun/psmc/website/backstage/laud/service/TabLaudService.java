package priv.guochun.psmc.website.backstage.laud.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;

public interface TabLaudService {

	/**
	 * 查询点赞列表
	 * @param myPage
	 * @return
	 */
	public MyPage queryLaudPage(MyPage myPage, String businessType);
	
	/**
	 * 点赞
	 * @param moduleUuid
	 * @param laudPersonUuid
	 */
	public void addLaud(String moduleUuid, String laudPersonUuid);
	
	/**
	 * 取消点赞
	 * @param moduleUuid
	 * @param laudPersonUuid
	 */
	public void deleteLaud(String moduleUuid, String laudPersonUuid);
	
	/**
	 * 查询是否点赞
	 * @param moduleUuid
	 * @param laudPersonUuid
	 * @return
	 */
	public boolean selectIsLaud(String moduleUuid, String laudPersonUuid);
	
	/**
	 * 查询点赞列表
	 * @param moduleUuid 业务信息id
	 * @param businessType 业务类型
	 * @return
	 */
	public List<Map<String, Object>> queryLaudList(String moduleUuid, String businessType);
}
