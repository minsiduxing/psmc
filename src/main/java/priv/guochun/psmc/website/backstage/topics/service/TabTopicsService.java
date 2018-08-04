package priv.guochun.psmc.website.backstage.topics.service;

import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;

/**
 * 主题信息服务类
 * @author Administrator
 *
 */
public interface TabTopicsService {

	/**
	 * 手机端保存或修改主题信息
	 * @param tabTopics
	 */
	public void saveOrUpdateToMobile(TabTopics tabTopics);
	
	/**
	 * 移动端查询主题列表
	 * @param myPage
	 * @return
	 */
	public MyPage queryTopicListToMobile(MyPage myPage);
	
	/**
	 * 移动端查询主题详情
	 * @param topicUuid
	 * @return
	 */
	public Map<String, Object> queryTopicsToMobile(String topicUuid);
}
