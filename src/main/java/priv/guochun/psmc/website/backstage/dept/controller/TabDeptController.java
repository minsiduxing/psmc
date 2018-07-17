package priv.guochun.psmc.website.backstage.dept.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.dept.model.TabDept;
import priv.guochun.psmc.website.backstage.dept.service.TabDeptService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

@Controller
@RequestMapping("/website/backstage/TabDeptController")
public class TabDeptController extends MyController{

	@Autowired
	private TabDeptService tabDeptService;
	
	/**
	 * 查询部门列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=findDeptList")
	@ResponseBody
	public void findDeptList(MyPage myPage, String deptType) throws IOException{
		Map<String,Object> parameterMap = myPage.getQueryParams();
		if(parameterMap == null){
			parameterMap = new HashMap<String, Object>();
		}
		//根据当前用户的分组编码过滤数据
		Map<String, TabPerson> person = this.getUserBySeesion(this.request()).getTabPerson();
		parameterMap.put("groupid", person.get("groupid"));
		parameterMap.put("deptType", deptType);
		myPage.setQueryParams(parameterMap);
		myPage = tabDeptService.findDeptListBusinessMethod(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 新增或修改部门信息
	 * @param dept
	 * @param isEdit
	 * @param module
	 * @throws IOException 
	 */
	@RequestMapping(params="method=saveOrUpdateDept")
	public void saveOrUpdateDept(TabDept dept, String isEdit, TabModule module) throws IOException{
		User user = this.getUserBySeesion(this.request());
		if("add".equals(isEdit)){
			dept.setCreatePerson(user.getUserUuid());
			dept.setLastModifyPerson(user.getUserUuid());
			dept.setGroupid(String.valueOf(user.getTabPerson().get("groupid")));
			module.setCreateAccUuid(user.getUserUuid());
		}else{
			dept.setLastModifyPerson(user.getUserUuid());
			module.setModelUuid(dept.getDeptUuid());
			module.setModifyAccUuid(user.getUserUuid());
		}
		//如果配图为空，则添加默认配图
		if(StringUtils.isBlank(dept.getImagePath())){
			dept.setImagePath(SystemPropertiesUtil.getWorkManageImagePath());
		}
		tabDeptService.saveOrUpdateDeptBusinessMethod(dept, module);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 删除部门信息
	 * @param uuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=deleteDept")
	public void deleteDept(String uuids) throws IOException{
		tabDeptService.deleteDeptBusinessMethod(uuids);
		super.responseJson(true, "部门删除成功!", this.response());
	}
	
	/**
	 * 审核部门
	 * @param uuids
	 * @throws IOException 
	 */
	@RequestMapping(params="method=auditDept")
	public void auditDept(String uuids) throws IOException{
		tabDeptService.auditDeptBusinessMethod(uuids, this.getUserBySeesion(this.request()).getUserUuid());
		super.responseJson(true, "部门审核成功!", this.response());
	}
	
	/**
	 * 发布部门
	 * @param uuids
	 * @throws IOException 
	 */
	@RequestMapping(params="method=releaseDept")
	public void releaseDept(String uuids) throws IOException{
		tabDeptService.releaseDeptBusinessMethod(uuids, this.getUserBySeesion(this.request()).getUserUuid());
		super.responseJson(true, "部门发布成功!", this.response());
	}
	
	/**
	 * 跳转到部门列表页面
	 * @throws IOException
	 */
	@RequestMapping(params="method=toDeptList")
	public String toDeptList(){
		return "backstage/dept/deptList";
	}
	
	/**
	 * 跳转到部门编辑页面
	 * @param deptUuid
	 * @param isEdit
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=toDeptEdit")
	public String toDeptEdit(String deptUuid, String isEdit, String deptType, Model model){
		if(StringUtils.isNotBlank(deptUuid)){
			Map<String, Object> dept = tabDeptService.queryDeptByUuidBusinessMethod(deptUuid);
			model.addAttribute("dept", dept);
		}
		model.addAttribute("deptType", deptType);
		model.addAttribute("isEdit", isEdit);
		return "backstage/dept/addOrUpdateDept";
	}
	
	/**
	 * 加载部门信息
	 * @param deptType
	 * @throws IOException
	 */
	@RequestMapping(params="method=loadDept")
	@ResponseBody
	public void loadDept(String deptType, String groupid) throws IOException{
		List<Map<?, ?>> list = tabDeptService.getDeptListByDeptType(deptType, groupid);
		JSONArray ja = JsonUtil.convertToJSONArray(list);
        super.responseJson(ja, this.response());
	}
	
}
