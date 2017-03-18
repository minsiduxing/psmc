package priv.guochun.psmc.authentication.role.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.role.model.TabRole;
import priv.guochun.psmc.authentication.role.service.TabRoleService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;

@Controller
@RequestMapping("/authentication/roleController")
public class TabRoleController extends MyController {
	protected static final Logger logger = LoggerFactory
			.getLogger(TabRoleController.class);

	@Autowired
	private TabRoleService tabRoleService;
	
	static SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * @param request
	 * @param response
	 * @param mypage
	 * @throws IOException
	 * @Description: 初始化角色列表
	 */
	@RequestMapping(params = "method=rolesList")
	@ResponseBody
	public void rolesList(HttpServletResponse response, MyPage mypage)
			throws IOException {
		mypage = tabRoleService.getRolesListBusinessMethod(mypage);
		super.responseJson(JsonUtil.convertToJSONObject(mypage), response);
	}

	/**
	 * 账号新增、修改入口
	 * 
	 * @param request
	 * @param response
	 * @param uuid
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params = "method=initEdit")
	public String initEdit(HttpServletResponse response, String uuid,
			String oper, ModelMap modelMap) throws IOException {

		Map<?, ?> role = null;
		if (StringUtils.isNotBlank(uuid)) {
			role = tabRoleService.getTabRole(uuid);
		}

		modelMap.put("oper", oper);
		modelMap.put("role", role);
		return "authentication/role/role_edit";
	}

	/**
	 * 校验账号是否唯一
	 * 
	 * @param request
	 * @param response
	 * @param mypage
	 * @throws IOException
	 */
	@RequestMapping(params = "method=roleUniqueValidate")
	@ResponseBody
	public void roleUniqueValidate(String uuid, String roleNo,
			HttpServletResponse response) throws IOException {

		boolean result = tabRoleService.executeRoleUniqueValidate(roleNo,
		        uuid);
		super.responseJson(result, null, response);
	}

	@RequestMapping(params = "method=edit")
	@ResponseBody
	public void edit(HttpServletRequest request,HttpServletResponse response, TabRole role)
			throws IOException {
		if (StringUtils.isBlank(role.getUuid())) {
			role.setUuid(UUIDGenerator.createUUID());
			User user = (User)request.getSession().getAttribute("user");
			role.setCreator(user.getAccountName());
			Timestamp now = new Timestamp(System.currentTimeMillis());
	        role.setCreateTime(now);
		}
		boolean exits = tabRoleService.executeRoleUniqueValidate(role.getRoleNo(),role.getUuid());
		if(!exits){
		    super.responseJson(exits, "角色编号在系统中已存在,不能重复录入", response);
		}else{
		    boolean result = tabRoleService.saveOrUpdateRoleBusinessMethod(role);
	        super.responseJson(result, null, response);
		}
		
	}

	@RequestMapping(params = "method=deletes")
	@ResponseBody
	public void deletes(HttpServletResponse response, String uuids)
			throws IOException {
		boolean result = tabRoleService.deletesRoleByUuidsBusinessMethod(uuids);
		if(!result)
		    super.responseJson(result, "角色在系统中已被关联到账户使用无法删除!", response);
		else
		    super.responseJson(result, null, response);
	}
	
	/**
	 * 获取角色列表选择下拉框的数据
	 * @param response
	 * @param role
	 * @throws IOException
	 */
	@RequestMapping(params = "method=loadComboRoleList")
    @ResponseBody
    public void loadComboRoleList(HttpServletResponse response,TabRole role)
            throws IOException {
	    List<Map<?, ?>> list = tabRoleService.getAllPageRolesList(role);
        super.responseJson(JsonUtil.convertToJSONArray(list), response);
    }
	
	
}
