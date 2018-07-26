package priv.guochun.psmc.website.backstage.excellentInnovation.controller;

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
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.excellentInnovation.model.TabExcellentInnovation;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

@Controller
@RequestMapping("/website/backstage/ExcellentInnovationController")
public class ExcellentInnovationController extends MyController{
	
	@Autowired
	private ExcellentInnovationService excellentInnovationService;
	
	/**
	 * 查询优秀成果信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=excellentInnovationList")
	@ResponseBody
	public void excellentInnovationList(MyPage myPage) throws IOException{
		myPage = excellentInnovationService.getInnovationListBusinessMethod(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 保存或修改优秀创新成果信息
	 * @param innovation
	 * @param module
	 * @param isEdit
	 * @throws IOException
	 */
	@RequestMapping(params="method=saveOrUpdate")
	public void saveOrUpdate(TabExcellentInnovation innovation,TabModule module,String isEdit) throws IOException{
		if(isEdit.equals("add")){
			module.setCreateAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		}else{
			module.setModelUuid(innovation.getInnovationUuid());
			module.setModifyAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		}
		//如果信息配图为空，则添加默认配图
		if(ContantsUtil.IS_CUSTOM_0.equals(innovation.getIsCustom()) && StringUtils.isBlank(innovation.getImagePath())){
			innovation.setImagePath(SystemPropertiesUtil.getInnovationImagePath());
		}
		module.setAuditDate(null);
		excellentInnovationService.saveOrUpdateInnovationBusinessMethod(innovation, module);
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
		excellentInnovationService.deleteBusinessMethod(uuids);
		super.responseJson(true, "信息删除成功!", this.response());
	}
	
	/**
	 * 审核信息
	 * @param response
	 * @param request
	 * @param newsIds
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeAudit")
	public void executeAudit(String uuids) throws IOException{
		String userId = this.getUserBySeesion(this.request()).getUserUuid();
		excellentInnovationService.executeAuditBusinessMethod(uuids, userId);
		super.responseJson(true, "信息审核成功!", this.response());
	}
	
	/**
	 * 发布信息
	 * @param response
	 * @param request
	 * @param newsIds
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeRelease")
	public void executeRelease(String uuids,Timestamp publishExpireDate) throws IOException{
		String userId = this.getUserBySeesion(this.request()).getUserUuid();
		excellentInnovationService.executeReleaseBusinessMethod(uuids, userId, publishExpireDate);
		super.responseJson(true, "信息发布成功!", this.response());
	}
	/**
	 * 信息预览
	 * @param response
	 * @param request
	 * @param newsId
	 * @throws IOException
	 */
	@RequestMapping(params="method=getInfoReleaseByUuid")
	public void getinnovationByUuid(String uuid) throws IOException{
		Map<String, Object> map = excellentInnovationService.getInnovationByUuidBusinessMethod(uuid);
		super.responseJson(JsonUtil.convertToJSONObject(map), this.response());
	}
	
	/**
	 * 跳转到优秀成果信息列表界面
	 * @return
	 */
	@RequestMapping(params="method=innovationList")
	public String innovationList(){
		return "backstage/innovation/innovationList";
	}
	
	/**
	 * 跳转到优秀成果信息新增、编辑、查看页面
	 * @param uuid
	 * @param isEdit
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=innovationEdit")
	public String innovationEdit(String uuid, String isEdit, Model model){
		if(StringUtils.isNotBlank(uuid)){
			Map<String,Object> innovation = excellentInnovationService.getInnovationByUuidBusinessMethod(uuid);
			model.addAttribute("info", innovation);
		}
		model.addAttribute("isEdit", isEdit);
		return "backstage/innovation/addOrUpdateInnovation";
	}
	
}
