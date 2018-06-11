package priv.guochun.psmc.website.backstage.activity.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.activity.model.TabActivityManage;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

@Controller
@RequestMapping("/website/backstage/TabActivityManageController")
public class TabActivityManageController extends MyController{

	@Autowired
	private TabActivityManageService tabActivityManageService;
	/**
	 * 查询活动信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=queryActivityList")
	@ResponseBody
	public void queryActivityList(MyPage myPage) throws IOException{
		myPage = tabActivityManageService.queryActivityList(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 新增或修改优秀活动信息
	 * @param activity
	 * @param module
	 * @param isEdit
	 * @throws IOException
	 */
	@RequestMapping(params="method=addOrUpdate")
	public void addOrUpdate(TabActivityManage activity,TabModule module,String isEdit) throws IOException{
		if(StringUtils.isBlank(isEdit)){
			module.setCreateAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		}else{
			module.setModelUuid(activity.getActivityUuid());
			module.setModifyAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		}
		tabActivityManageService.addOrupdateActivity(activity, module);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 删除信息
	 * @param uuids
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=deleteByUuids")
	public void deleteByUuids(String uuids) throws IOException{
		tabActivityManageService.deleteActivity(uuids);
		super.responseJson(true, "信息删除成功!", this.response());
	}
	
	/**
	 * 审核信息
	 * @param uuids
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeAudit")
	public void executeAudit(String uuids) throws IOException{
		String userId = this.getUserBySeesion(this.request()).getUserUuid();
		tabActivityManageService.executeAudit(uuids, userId);
		super.responseJson(true, "信息审核成功!", this.response());
	}
	
	/**
	 * 发布信息
	 * @param uuids
	 * @param publishExpireDate
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeRelease")
	public void executeRelease(String uuids,Timestamp publishExpireDate) throws IOException{
		String userId = this.getUserBySeesion(this.request()).getUserUuid();
		tabActivityManageService.executeRelease(uuids, userId, publishExpireDate);
		super.responseJson(true, "信息发布成功!", this.response());
	}
	
	/**
	 * 跳转到活动信息列表界面
	 * @return
	 */
	@RequestMapping(params="method=activityList")
	public String activityList(){
		return "backstage/activity/activityList";
	}
	
	/**
	 * 跳转到活动信息编辑页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=activityEdit")
	public String activityEdit(String uuid,Model model){
		Map<String,Object> activity = tabActivityManageService.getActivityByUuid(uuid);
		model.addAttribute("info", activity);
		model.addAttribute("isEdit", "isEdit");
		return "backstage/activity/addOrUpdateActivity";
	}
}
