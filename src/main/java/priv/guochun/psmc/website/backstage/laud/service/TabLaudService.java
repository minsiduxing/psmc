package priv.guochun.psmc.website.backstage.laud.service;

import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;

public interface TabLaudService {

	/**
	 * 查询点赞列表
	 * @param myPage
	 * @return
	 */
	public MyPage queryLaudList(MyPage myPage);
	
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
}
