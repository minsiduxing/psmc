package priv.guochun.psmc.website.backstage.topics.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;
import priv.guochun.psmc.website.backstage.topics.service.TabTopicsService;

public class TabTopicsServiceImpl implements TabTopicsService{
	
	private static final String selectTopicsList = "selectTopicsList";
	private static final String selectTopicsByPrimaryKey = "selectTopicsByPrimaryKey";
	private static final String insertTopics = "insertTopics";
	private static final String updateTopics = "updateTopics";
	private static final String updateTopicsStatus = "updateTopicsStatus";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabAttachmentService tabAttachmentService;
	
	@Override
	public void saveOrUpdateToMobile(TabTopics tabTopics) {
		if(tabTopics == null) {
			throw new PsmcBuisnessException("主题信息数据为null!");
		}
		if(StringUtils.isBlank(tabTopics.getTopicUuid())) {
			//新增
			String topicUuid = UUIDGenerator.createUUID();
			tabTopics.setTopicUuid(topicUuid);
			tabTopics.setCreateDate(DateUtil.getCurrentTimstamp());
			//初始为正常状态
			tabTopics.setTopicStatus(ContantsUtil.BLOCK_STATUS_1);
			baseDao.insert(insertTopics, tabTopics);
			//添加附件信息
			tabAttachmentService.updateBusinessUuidToAttachment(topicUuid, tabTopics.getAttachmentUuids());
		}else{
			baseDao.update(updateTopics, tabTopics);
		}
	}
	
	@Override
	public MyPage queryTopicListToMobile(MyPage myPage){
		Map<String,Object> condition = myPage.getQueryParams();
		 //查询参数添加
		if(condition == null){
			condition = new HashMap<String,Object>();
		}
		return baseDao.getMyPage(myPage, selectTopicsList, condition);
	}
	
	@Override
	public Map<String, Object> queryTopicsToMobile(String topicUuid){
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("topicUuid", topicUuid);
		return (Map<String, Object>) baseDao.queryForObject(selectTopicsByPrimaryKey, condition);
	}
	
	@Override
	public MyPage queryTopicListBusinessMethod(MyPage myPage) {
		return this.queryTopicListToMobile(myPage);
	}
	
	@Override
	public Map<String, Object> queryTopicsBusinessMethod(String topicUuid) {
		return this.queryTopicsToMobile(topicUuid);
	}
	
	@Override
	public void updateTopicsStatusBusinessMethod(TabTopics tabTopics) {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("ids", tabTopics.getTopicUuid().split(","));
		condition.put("topicStatus", tabTopics.getTopicStatus());
		baseDao.update(updateTopicsStatus, condition);
	}
}
