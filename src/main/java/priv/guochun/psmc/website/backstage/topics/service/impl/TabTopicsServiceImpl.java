package priv.guochun.psmc.website.backstage.topics.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.Cache;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;
import priv.guochun.psmc.website.backstage.topics.service.TabTopicsService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class TabTopicsServiceImpl implements TabTopicsService{
	
	private static final String selectTopicsList = "selectTopicsList";
	private static final String selectTopicsByPrimaryKey = "selectTopicsByPrimaryKey";
	private static final String insertTopics = "insertTopics";
	private static final String updateTopics = "updateTopics";
	private static final String updateTopicsStatus = "updateTopicsStatus";
	private static final String updateTopics2 = "updateTopics2";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabAttachmentService tabAttachmentService;
	
	@Override
	public void saveOrUpdateToMobile(TabTopics tabTopics) {
		if(tabTopics == null) {
			throw new PsmcBuisnessException("主题信息数据为null!");
		}
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String file_prefix_path =map.get("file_prefix_path").toString();
		String activity_image_path =map.get("activity_image_path").toString();
		String help_declare_image_path =map.get("help_declare_image_path").toString();
		String innovation_image_path =map.get("innovation_image_path").toString();
		String law_help_image_path =map.get("law_help_image_path").toString();
		String work_manage_image_path =map.get("work_manage_image_path").toString();


		if(StringUtils.isBlank(tabTopics.getTopicUuid())) {
			//新增
			String topicUuid = UUIDGenerator.createUUID();
			tabTopics.setTopicUuid(topicUuid);
			tabTopics.setCreateDate(DateUtil.getCurrentTimstamp());
			//初始为正常状态
			tabTopics.setTopicStatus(ContantsUtil.BLOCK_STATUS_1);
			//发布状态为未发布
			tabTopics.setReleaseStatus(Integer.valueOf(ModuleEnum.NOT_RELEASE.getValue()));
			//添加列表的默认配图
			String imagePath = "";
			if(ContantsUtil.BLOCK_01.equals(tabTopics.getBlockUuid())){
				imagePath = file_prefix_path + activity_image_path;
			}else if(ContantsUtil.BLOCK_02.equals(tabTopics.getBlockUuid())){
				imagePath = file_prefix_path + help_declare_image_path;
			}else if(ContantsUtil.BLOCK_03.equals(tabTopics.getBlockUuid())){
				imagePath = file_prefix_path + innovation_image_path;
			}else if(ContantsUtil.BLOCK_04.equals(tabTopics.getBlockUuid())){
				imagePath = file_prefix_path+ law_help_image_path;
			}else if(ContantsUtil.BLOCK_05.equals(tabTopics.getBlockUuid())){
				imagePath = file_prefix_path+ work_manage_image_path;
			}
			tabTopics.setImagePath(imagePath);
			baseDao.insert(insertTopics, tabTopics);
		}else{
			baseDao.update(updateTopics, tabTopics);
		}
		//添加附件信息
		tabAttachmentService.updateBusinessUuidToAttachment(tabTopics.getTopicUuid(), tabTopics.getAttachmentUuids());
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
	
	@Override
	public void executeReleaseBusinessMethod(String topicUuids, String personUuid){
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("ids", topicUuids.split(","));
		condition.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		condition.put("releaseTime", DateUtil.getCurrentTimstamp());
		condition.put("releasePersonUuid", personUuid);
		baseDao.update(updateTopicsStatus, condition);
	}
	
	@Override
	public void executeBanReleaseBusinessMethod(String topicUuids, String personUuid){
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("ids", topicUuids.split(","));
		condition.put("releaseStatus", ModuleEnum.NOT_RELEASE.getValue());
		condition.put("releaseTime", null);
		condition.put("releasePersonUuid", null);
		baseDao.update(updateTopics2, condition);
	}
	
	@Override
	public void saveOrUpdateBusinessMethod(TabTopics tabTopics) {
		this.saveOrUpdateToMobile(tabTopics);
	}
	
	@Override
	public void deleteTopicToMobile(TabTopics tabTopics) {
		this.updateTopicsStatusBusinessMethod(tabTopics);
	}
}
