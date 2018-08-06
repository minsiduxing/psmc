package priv.guochun.psmc.website.backstage.topics.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
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
	public void tabCommentList(MyPage myPage, String topicUuid) throws IOException {
		Map<String, Object> paramsMap = myPage.getQueryParams();
		if(paramsMap == null) {
			paramsMap = new HashMap<String, Object>(); 
		}
		paramsMap.put("topicUuid", topicUuid);
		myPage = tabCommentService.queryCommentListToMobile(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 跳转到主题信息列表页面
	 * @return
	 */
	@RequestMapping(params="method=toCommentListPage")
	public String toCommentListPage(){
		return "backstage/topics/commentList";
	}

}
