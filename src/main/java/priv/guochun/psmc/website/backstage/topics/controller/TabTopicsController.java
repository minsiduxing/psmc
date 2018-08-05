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
import priv.guochun.psmc.website.backstage.topics.service.TabTopicsService;

@Controller
@RequestMapping("/website/backstage/tabTopicsController")
public class TabTopicsController extends MyController{

	@Autowired
	private TabTopicsService tabTopicsService;
	@Autowired
	private TabCommentService tabCommentService;
	
	/**
	 * 查询主题信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=tabTopicsList")
	@ResponseBody
	public void tabTopicsList(MyPage myPage) throws IOException{
		Map<String, Object> paramsMap = myPage.getQueryParams();
		if(paramsMap == null){
			paramsMap = new HashMap<String, Object>();
		}
		myPage.setQueryParams(paramsMap);
		myPage = tabTopicsService.queryTopicListBusinessMethod(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 主题详细信息
	 * @param topicUuid
	 * @throws IOException
	 */
	@RequestMapping(params="method=topicsDetail")
	public void topicsDetail(String topicUuid) throws IOException{
		Map<String, Object> topics = tabTopicsService.queryTopicsBusinessMethod(topicUuid);
		super.responseJson(JsonUtil.convertToJSONObject(topics), this.response());
	}
	
	/**
	 * 暂停主题评论功能
	 * @param topicUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=pauseTopicsComment")
	public void pauseTopicsComment(String topicUuids) throws IOException{
		TabTopics topics = new TabTopics();
		topics.setTopicUuid(topicUuids);
		topics.setTopicStatus(ContantsUtil.BLOCK_STATUS_2);
		tabTopicsService.updateTopicsStatusBusinessMethod(topics);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 删除主题信息
	 * @param topicUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=deleteTopics")
	public void deleteTopics(String topicUuids) throws IOException{
		TabTopics topics = new TabTopics();
		topics.setTopicUuid(topicUuids);
		topics.setTopicStatus(ContantsUtil.BLOCK_STATUS_3);
		tabTopicsService.updateTopicsStatusBusinessMethod(topics);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 屏蔽评论信息
	 * @param topicUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=hideComment")
	public void hideComment(String commentUuids) throws IOException{
		TabComment comment = new TabComment();
		comment.setCommentUuid(commentUuids);
		comment.setCommentStatus(ContantsUtil.BLOCK_STATUS_2);
		tabCommentService.updateCommentStatusBusinessMethod(comment);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 删除评论信息
	 * @param topicUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=deleteComment")
	public void deleteComment(String commentUuids) throws IOException{
		TabComment comment = new TabComment();
		comment.setCommentUuid(commentUuids);
		comment.setCommentStatus(ContantsUtil.BLOCK_STATUS_2);
		tabCommentService.updateCommentStatusBusinessMethod(comment);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 跳转到主题信息列表页面
	 * @return
	 */
	@RequestMapping(params="method=toTopicsListPage")
	public String toTopicsListPage(){
		return "backstage/topics/topicsList";
	}
}
