package priv.guochun.psmc.website.backstage.activity.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.activity.model.TabActivityManage;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;

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
		Map<String,Object> parameterMap = myPage.getQueryParams();
		if(parameterMap == null){
			parameterMap = new HashMap<String, Object>();
		}
		//根据当前用户的分组编码过滤数据
		Map<String, TabPerson> person = this.getUserBySeesion(this.request()).getTabPerson();
		parameterMap.put("groupid", person.get("groupid"));
		myPage.setQueryParams(parameterMap);
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
		if(isEdit.equals("add")){
			activity.setCreateDate(DateUtil.getCurrentTimstamp());
			activity.setCreatePerson(this.getUserBySeesion(this.request()).getPersonName());
			module.setCreateAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		}else{
			module.setModelUuid(activity.getActivityUuid());
			module.setModifyAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		}
		//如果配图为空，则添加默认配图
		if(ContantsUtil.IS_CUSTOM_0.equals(activity.getIsCustom()) && StringUtils.isBlank(activity.getImagePath())){
			activity.setImagePath(SystemPropertiesUtil.getActivityImagePath());
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
	 * 撤销
	 * @param activityUuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=executeUndo")
	public void executeUndo(String activityUuids) throws IOException {
		TabModule module = new TabModule();
		module.setModifyAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		tabActivityManageService.executeUndoBusinessMethod(activityUuids, module);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 查询报名分页信息
	 * @param myPage
	 * @param activityUuid
	 * @throws IOException
	 */
	@RequestMapping(params="method=querySignUpInfoPage")
	public void querySignUpInfoPage(MyPage myPage, String activityUuid) throws IOException{
		Map<String,Object> parameterMap = myPage.getQueryParams();
		if(parameterMap == null){
			parameterMap = new HashMap<String, Object>();
		}
		parameterMap.put("activityUuid", activityUuid);
		myPage.setQueryParams(parameterMap);
		myPage = tabActivityManageService.querySignInfoPage(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 导出报名信息
	 * @param activityUuid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=exportSignUpInfo")
	public View exportSignUpInfo( String activityUuid) throws IOException{
		//1、根据条件查询报名信息列表
		List signUpList = tabActivityManageService.querySignUpInfoList(activityUuid);
		//2、将得到的数据封装到excel里
		//2.1 设置属性列名
		this.setColumns(new String[]{"activity_name","person_name","person_mobile","sign_up_date","start_date","end_date"});
		//2.2 设置表格的显示名
		this.setTitles(new String[]{"活动名称","姓名","联系电话","报名时间","活动开始时间","活动结束时间"});
		//2.3设置文件名
		this.setFileName("报名信息列表.xls");
		//2.4 初始化数据
		this.setExportList(signUpList);
		//3、返回excel下载视图
		return this.responseExcelFile(this.response()) ;
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
	 * @param isEdit
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=activityEdit")
	public String activityEdit(String uuid, String isEdit, Model model){
		if(StringUtils.isNotBlank(uuid)){
			Map<String,Object> activity = tabActivityManageService.getActivityByUuid(uuid);
			model.addAttribute("info", activity);
		}
		model.addAttribute("isEdit", isEdit);
		return "backstage/activity/addOrUpdateActivity";
	}
}
