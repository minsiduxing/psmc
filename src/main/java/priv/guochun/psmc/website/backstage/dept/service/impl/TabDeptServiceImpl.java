package priv.guochun.psmc.website.backstage.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.dept.model.TabDept;
import priv.guochun.psmc.website.backstage.dept.service.TabDeptService;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class TabDeptServiceImpl implements TabDeptService {
	
	private final static String selectDeptList = "selectDeptList";
	private final static String selectDeptByPrimaryKey = "selectDeptByPrimaryKey";
	private final static String deleteDeptByPrimaryKey = "deleteDeptByPrimaryKey";
	private final static String insertDept = "insertDept";
	private final static String updateDeptByPrimaryKey = "updateDeptByPrimaryKey";
	private final static String selectDeptByDeptType = "selectDeptByDeptType";
	
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
    private TabModuleService tabModuleService;
	
	@Autowired
	private ExcellentInnovationService excellentInnovationService;
	
	@Autowired
	private TabActivityManageService tabActivityManageService;
	
	@Override
	public MyPage findDeptListBusinessMethod(MyPage page) {
		Map<String, Object> condition = page.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		return baseDao.getMyPage(page, selectDeptList, condition);
	}

	@Override
	public Map<String, Object> queryDeptByUuidBusinessMethod(String deptUuid) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("deptUuid", deptUuid);
		return (Map<String, Object>) baseDao.queryForObject(selectDeptByPrimaryKey, condition);
	}

	@Override
	public void saveOrUpdateDeptBusinessMethod(TabDept dept, TabModule module) {
		if(null == dept){
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		if(StringUtils.isBlank(dept.getDeptUuid())){
			String uuid = UUIDGenerator.createUUID();
			dept.setDeptUuid(uuid);
			dept.setCreateDate(DateUtil.getCurrentTimstamp());
			dept.setLastModifyTime(DateUtil.getCurrentTimstamp());
			module.setModelUuid(uuid);
			module.setCreateDate(DateUtil.getCurrentTimstamp());
			module.setReleaseStatus(ModuleEnum.NOT_RELEASE.getValue());
			module.setAudit(new Integer(ModuleEnum.NOT_AUDITED.getValue()));
			baseDao.insert(insertDept, dept);
		}else{
			dept.setLastModifyTime(DateUtil.getCurrentTimstamp());
			module.setModifyDate(DateUtil.getCurrentTimstamp());
			baseDao.update(updateDeptByPrimaryKey, dept);
		}
		tabModuleService.saveOrupdateTabmodule(module);
	}

	@Override
	public void deleteDeptBusinessMethod(String ids, String deptType) {
		//删除模块信息
		tabModuleService.deleteTabModulebyUuids(ids);
		Map<String, Object> condition = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(ids)){
			condition.put("deptUuids", ids.split(","));
		}
		//删除部门信息
		baseDao.delete(deleteDeptByPrimaryKey, condition);
		//删除部门下的创新成果或活动信息
		if(ModuleEnum.DEPT_TYPE_1.getValue().equals(deptType)){
			excellentInnovationService.deleteInnovationByDeptUuid(ids);
		}else{
			tabActivityManageService.deleteActivityByDeptUuid(ids);
		}
	}

	@Override
	public void auditDeptBusinessMethod(String uuids, String userId) {
		tabModuleService.executeAuditModule(uuids, userId);
	}

	@Override
	public void releaseDeptBusinessMethod(String uuids, String userId) {
		TabModule module = new TabModule();
		module.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		module.setReleaseAccUuid(userId);
		module.setModifyAccUuid(userId);
		tabModuleService.executeReleaseModule(uuids, module);
	}
	
	@Override
	public void executeUndoBusinessMethod(String deptUuids, TabModule module) {
		tabModuleService.executeUndoTabModule(deptUuids, module);
	}
	
	@Override
	public List<Map<?, ?>> getDeptListByDeptType(String deptType, String groupid) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("deptType", deptType);
		condition.put("groupid", groupid);
		//下拉列表只能选择已经发布的部门
		condition.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		return baseDao.queryForList(selectDeptByDeptType, condition);
	}

	@Override
	public Map<String, Object> getDeptDetailToMobile(String deptUuid) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("deptUuid", deptUuid);
		return (Map<String, Object>) baseDao.queryForObject(selectDeptByPrimaryKey, condition);
	}

	@Override
	public MyPage queryDeptListToMobile(MyPage mypage) {
		Map<String, Object> condition = mypage.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		return baseDao.getMyPage(mypage, selectDeptList, condition);
	}
	
	
}
