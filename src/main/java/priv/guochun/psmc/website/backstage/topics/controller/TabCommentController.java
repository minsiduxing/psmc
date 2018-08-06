package priv.guochun.psmc.website.backstage.topics.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;
import priv.guochun.psmc.website.backstage.topics.service.TabCommentService;

@Controller
@RequestMapping("/website/backstage/tabCommentController")
public class TabCommentController extends MyController {
	
	@Autowired
	private TabCommentService tabCommentService;
	
	/**
	 * 评论信息分页列表
	 * @param myPage
	 * @param topicUuid
	 * @throws IOException
	 */
	@RequestMapping(params="method=tabCommentList")
	@ResponseBody
	public void tabCommentList(MyPage myPage, String topicUuid) throws IOException {
		Map<String, Object> paramsMap = myPage.getQueryParams();
		if(paramsMap == null) {
			paramsMap = new HashMap<String, Object>(); 
		}
		paramsMap.put("topicUuid", topicUuid);
		myPage.setQueryParams(paramsMap);
		myPage = tabCommentService.queryCommentListToMobile(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 屏蔽评论信息
	 * @param commentUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=pauseComment")
	public void pauseComment(String commentUuids) throws IOException{
		TabComment comment = new TabComment();
		comment.setCommentUuid(commentUuids);
		comment.setCommentStatus(ContantsUtil.BLOCK_STATUS_2);
		tabCommentService.updateCommentStatus(comment);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 删除评论信息
	 * @param commentUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=deleteComment")
	public void deleteComment(String commentUuids) throws IOException{
		TabComment comment = new TabComment();
		comment.setCommentUuid(commentUuids);
		comment.setCommentStatus(ContantsUtil.BLOCK_STATUS_3);
		tabCommentService.updateCommentStatus(comment);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 撤销操作
	 * @param commentUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=undoComment")
	public void undoComment(String commentUuids) throws IOException {
		TabComment comment = new TabComment();
		comment.setCommentUuid(commentUuids);
		comment.setCommentStatus(ContantsUtil.BLOCK_STATUS_1);
		tabCommentService.updateCommentStatus(comment);
		super.responseJson(true, "操作成功!", this.response());

	}

}
