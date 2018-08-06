package priv.guochun.psmc.website.backstage.topics.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;
import priv.guochun.psmc.website.backstage.topics.service.TabCommentService;
import priv.guochun.psmc.website.backstage.topics.service.TabTopicsService;

public class TabCommentServiceImpl implements TabCommentService{
	
	private static final String selectCommentList = "selectCommentList";
	private static final String insertComment = "insertComment";
	private static final String updateComment = "updateComment";
	private static final String updateCommentStatus = "updateCommentStatus";

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabTopicsService tabTopicsService;
	
	@Override
	public MyPage queryCommentListToMobile(MyPage myPage){
		Map<String,Object> condition = myPage.getQueryParams();
		 //查询参数添加
		if(condition == null){
			condition = new HashMap<String,Object>();
		}
		return baseDao.getMyPage(myPage, selectCommentList, condition);
	}
	
	@Override
	public void saveOrUpdateToMobile(TabComment tabComment) {
		if(tabComment == null){
			throw new PsmcBuisnessException("评论信息数据为空！");
		}
		if(StringUtils.isBlank(tabComment.getCommentUuid())){
			Timestamp currentTime = DateUtil.getCurrentTimstamp();
			//评论信息
			String commentUuid =  UUIDGenerator.createUUID();
			tabComment.setCommentUuid(commentUuid);
			tabComment.setCommentDate(currentTime);
			tabComment.setCommentStatus(ContantsUtil.BLOCK_STATUS_1);
			//主题信息
			TabTopics tabTopics = new TabTopics();
			tabTopics.setTopicUuid(tabComment.getTopicUuid());
			tabTopics.setLastCommentDate(currentTime);
			tabTopics.setLastCommentPersonUuid(tabComment.getCommentPersonUuid());
			tabTopics.setLastCommentUuid(commentUuid);
			baseDao.insert(insertComment, tabComment);
			tabTopicsService.saveOrUpdateToMobile(tabTopics);
		}else{
			baseDao.update(updateComment, tabComment);
		}
	}
	
	@Override
	public void updateCommentStatus(TabComment tabComment) {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("ids", tabComment.getCommentUuid().split(","));
		condition.put("commentStatus", tabComment.getCommentStatus());
		baseDao.update(updateCommentStatus, condition);
	}
}
