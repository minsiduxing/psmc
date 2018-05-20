package priv.guochun.psmc.website.backstage.InfoRelease.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoRelease;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.enums.ModuleEnum;

@Controller
@RequestMapping("/website/backstage/InfoReleaseController")
public class InfoReleaseController extends MyController{

	@Autowired
	private InfoReleaseService infoReleaseService;
	
	@Autowired
	private TabModuleService tabModuleService;
	
	/**
	 * 查询信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=getInfoReleaseList")
	@ResponseBody
	public void getInfoReleaseList(HttpServletRequest request, MyPage myPage, HttpServletResponse response) throws IOException{
		//获取当前用户角色
		String userRole = this.getUserBySeesion(request).getRoleNo();
		//获取信息分类
		String oneLevelClassify = getOneLevelClassify(userRole);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("oneLevelClassify", oneLevelClassify);
		myPage.setQueryParams(parameterMap);
		myPage = infoReleaseService.getInfoReleaseList(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), response);
	}
	
	/**
	 * 保存或修改发布信息
	 * @param request
	 * @param infoRelease
	 * @param module
	 * @param isEdit
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=saveOrUpdateInfoRelease")
	public void saveOrUpdateInfoRelease(HttpServletRequest request,InfoRelease infoRelease,TabModule module,String isEdit,HttpServletResponse response) throws IOException{
		if(StringUtils.isBlank(isEdit)){
			module.setCreateAccUuid(this.getUserBySeesion(request).getUserUuid());
		}else{
			module.setModelUuid(infoRelease.getNewsUuid());
			module.setModifyAccUuid(this.getUserBySeesion(request).getUserUuid());
		}
		infoReleaseService.saveOrUpdateInfoRelease(infoRelease, module);
		super.responseJson(true, "操作成功!", response);
	}
	
	/**
	 * 删除信息
	 * @param uuids
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=infoDelete")
	public void deleteInfoReleaseByUuids(String uuids, HttpServletResponse response) throws IOException{
		infoReleaseService.deleteInfoReleaseByUuids(uuids);
		super.responseJson(true, "信息删除成功!", response);
	}
	
	/**
	 * 审核信息
	 * @param response
	 * @param request
	 * @param newsIds
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeAuditInfo")
	public void executeAuditInfo(HttpServletResponse response,HttpServletRequest request,String newsIds) throws IOException{
		String userId = this.getUserBySeesion(request).getUserUuid();
		tabModuleService.executeAuditModule(newsIds, userId);
		super.responseJson(true, "信息审核成功!", response);
	}
	
	/**
	 * 发布信息
	 * @param response
	 * @param request
	 * @param newsIds
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeReleaseInfo")
	public void executeReleaseInfo(HttpServletResponse response,HttpServletRequest request,String newsIds) throws IOException{
		String userId = this.getUserBySeesion(request).getUserUuid();
		TabModule module = new TabModule();
		module.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		module.setReleaseAccUuid(userId);
		module.setModifyAccUuid(userId);
		tabModuleService.executeReleaseModule(newsIds, module);
		super.responseJson(true, "信息发布成功!", response);
	}
	
	/**
	 * 跳转到信息发布列表界面
	 * @return
	 */
	@RequestMapping(params="method=infoReleaseList")
	public String infoReleaseList(){
		return "backstage/infoRelease/infoReleaseList";
	}
	
	/**
	 * 跳转到信息添加或编辑页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=infoEdit")
	public String infoEdit(String uuid,Model model,HttpServletRequest request){
		Map<String,Object> InfoRelease = infoReleaseService.getInfoReleaseByUuid(uuid);
		//获取当前用户角色
		String userRole = this.getUserBySeesion(request).getRoleNo();
		//获取信息分类
		String oneLevelClassify = getOneLevelClassify(userRole);
		model.addAttribute("info", InfoRelease);
		model.addAttribute("isEdit", "isEdit");
		model.addAttribute("oneLevelClassify", oneLevelClassify);
		return "backstage/infoRelease/infoAddOrEdit";
	}
	
	/**
	 * 根据角色获取信息分类
	 * @param userRole
	 * @return
	 */
	private String getOneLevelClassify(String userRole){
		String oneLevelClassify = "";
		switch (userRole) {
			case ContantsUtil.SYS_INNOVATE_STUDIO_MAINTAIN:
				oneLevelClassify = ContantsUtil.ONE_LEVEL_CLASSIFY_11;
				break;
			case ContantsUtil.SYS_UNION_MAINTAIN:
				oneLevelClassify = ContantsUtil.ONE_LEVEL_CLASSIFY_12;
				break;
			case ContantsUtil.SYS_LITERARY_FORM_MAINTAIN:
				oneLevelClassify = ContantsUtil.ONE_LEVEL_CLASSIFY_13;
				break;
			case ContantsUtil.SYS_LOGISTICS_CENTER_MAINTIAN:
				oneLevelClassify = ContantsUtil.ONE_LEVEL_CLASSIFY_14;
				break;
		default:
			break;
		}
		return oneLevelClassify;
	}
}
