package priv.guochun.psmc.website.backstage.topics.service;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;

public interface TabCommentService {

	/**
	 * 查询评论列表
	 * @param myPage
	 * @return
	 */
	public MyPage queryCommentListToMobile(MyPage myPage);
	
	/**
	 * 添加或修改评论信息
	 * @param tabComment
	 */
	public void saveOrUpdateToMobile(TabComment tabComment);
	
	/**
	 * 更新状态
	 * @param tabComment
	 */
	public void updateCommentStatusBusinessMethod(TabComment tabComment);
}
