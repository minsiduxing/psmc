package priv.guochun.psmc.website.backstage.topics.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
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
	@Autowired
	private TabAttachmentService tabAttachmentService;
	
	/**
	 * 查询主题信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=tabTopicsList")
	@ResponseBody
	public void tabTopicsList(MyPage myPage, String blockUuid) throws IOException{
		Map<String, Object> paramsMap = myPage.getQueryParams();
		if(paramsMap == null){
			paramsMap = new HashMap<String, Object>();
		}
		paramsMap.put("blockUuid", blockUuid);
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
	 * 撤销操作
	 * @param topicUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=undoTopics")
	public void undoTopics(String topicUuids) throws IOException {
		TabTopics topics = new TabTopics();
		topics.setTopicUuid(topicUuids);
		topics.setTopicStatus(ContantsUtil.BLOCK_STATUS_1);
		tabTopicsService.updateTopicsStatusBusinessMethod(topics);
		super.responseJson(true, "操作成功!", this.response());

	}
	
	/**
	 * 发布
	 * @param topicUuids
	 * @throws IOException 
	 */
	@RequestMapping(params="method=releaseTopics")
	public void releaseTopics(String topicUuids) throws IOException{
		String userId = this.getUserBySeesion(this.request()).getUserUuid();
		tabTopicsService.executeReleaseBusinessMethod(topicUuids, userId);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 取消发布
	 * @param topicUuids
	 * @throws IOException 
	 */
	@RequestMapping(params="method=banReleaseTopics")
	public void banReleaseTopics(String topicUuids) throws IOException{
		String userId = this.getUserBySeesion(this.request()).getUserUuid();
		tabTopicsService.executeBanReleaseBusinessMethod(topicUuids, userId);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 添加修改
	 * @param topic
	 * @throws IOException 
	 */
	@RequestMapping(params="method=addTopics")
	public void addTopics(TabTopics topic) throws IOException{
		User user = this.getUserBySeesion(this.request());
		topic.setCreatePersonUuid(user.getUserUuid());
		topic.setCreatePersonName(user.getPersonName());
		topic.setTelephone(user.getPersonTelephone());
		tabTopicsService.saveOrUpdateBusinessMethod(topic);
		super.responseJson(true, "保存成功!", this.response());
	}
	
	/**
	 * 跳转到主题信息列表页面
	 * @return
	 */
	@RequestMapping(params="method=toTopicsListPage")
	public String toTopicsListPage(){
		return "backstage/topics/topicsList";
	}
	
	/**
	 * 跳转到主题信息详情页面
	 * @return
	 */
	@RequestMapping(params="method=toTopicsDetail")
	public String toTopicsDetail(String topicUuid, String blockUuid, Model model){
		Map<String, Object> topicMap = tabTopicsService.queryTopicsBusinessMethod(topicUuid);
		List<Map<String, Object>> attachmentList = tabAttachmentService.queryAttachmentList(topicUuid);
		model.addAttribute("topic", topicMap);
		model.addAttribute("attachmentList", attachmentList);
		model.addAttribute("topicUuid", topicUuid);
		model.addAttribute("blockUuid", blockUuid);
		return "backstage/topics/topicsDetails";
		
	}
	
	/**
	 * 跳转到添加修改界面
	 * @param topicUuid
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=toTopicsAddpage")
	public String toTopicsAddpage(String topicUuid, String blockUuid, Model model){
		if(StringUtils.isNotBlank(topicUuid)){
			Map<String, Object> topicMap = tabTopicsService.queryTopicsBusinessMethod(topicUuid);
			List<Map<String, Object>> attachmentList = tabAttachmentService.queryAttachmentList(topicUuid);
			model.addAttribute("topic", topicMap);
			model.addAttribute("attachmentList", attachmentList);
		}
		model.addAttribute("blockUuid", blockUuid);
		return "backstage/topics/topicsAddOrEdit";
	}
}
