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
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;
import priv.guochun.psmc.website.backstage.topics.service.TabCommentService;

public class TabCommentServiceImpl implements TabCommentService{
	
	private static final String selectBlockList = "selectBlockList";
	private static final String insertComment = "insertComment";
	private static final String updateComment = "updateComment";

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public MyPage queryCommentListToMobile(MyPage myPage){
		Map<String,Object> condition = myPage.getQueryParams();
		 //查询参数添加
		if(condition == null){
			condition = new HashMap<String,Object>();
		}
		return baseDao.getMyPage(myPage, selectBlockList, condition);
	}
	
	@Override
	public void saveOrUpdateToMobile(TabComment tabComment) {
		if(tabComment == null){
			throw new PsmcBuisnessException("评论信息数据为空！");
		}
		if(StringUtils.isBlank(tabComment.getCommentUuid())){
			String commentUuid =  UUIDGenerator.createUUID();
			tabComment.setCommentUuid(commentUuid);
			tabComment.setCommentDate(DateUtil.getCurrentTimstamp());
			tabComment.setCommentStatus(ContantsUtil.BLOCK_STATUS_1);
			baseDao.insert(insertComment, tabComment);
		}else{
			baseDao.update(updateComment, tabComment);
		}
	}
}
