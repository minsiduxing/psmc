package priv.guochun.psmc.website.backstage.excellentInnovation.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.excellentInnovation.model.TabExcellentInnovation;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class ExcellentInnovationServiceImpl implements ExcellentInnovationService{
	
	public static final String excellentInnovationList="excellentInnovationList";
    public static final String selectInnovationByPrimaryKey="selectInnovationByPrimaryKey";
    public static final String deleteInnovationByPrimaryKey="deleteInnovationByPrimaryKey";
    public static final String insertExcellentInnovation="insertExcellentInnovation";
    public static final String updateInnovation="updateInnovation";
    public static final String deleteInnovationByDeptUuid = "deleteInnovationByDeptUuid";

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TabModuleService tabModuleService;
    
    @Override
    public MyPage getInnovationListBusinessMethod(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
			condition.putAll(myPage.getQueryParams());
		}
		return baseDao.getMyPage(myPage, excellentInnovationList, condition);
	}

	@Override
	public void saveOrUpdateInnovationBusinessMethod(TabExcellentInnovation excellentInnovation, TabModule tabModule) {
		if(null==excellentInnovation || null == tabModule){
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		//判断是新增还是修改
		if(StringUtils.isBlank(excellentInnovation.getInnovationUuid())&&StringUtils.isBlank(tabModule.getModelUuid())){
			//执行模块初始化业务
			String uuid = UUIDGenerator.createUUID();
			tabModule.setModelUuid(uuid);
			tabModule.setCreateDate(DateUtil.getCurrentTimstamp());
			tabModule.setReleaseStatus(ModuleEnum.NOT_RELEASE.getValue());
			tabModule.setAudit(new Integer(ModuleEnum.NOT_AUDITED.getValue()));
			excellentInnovation.setInnovationUuid(uuid);
			baseDao.insert(insertExcellentInnovation, excellentInnovation);
		}else if(StringUtils.isNotBlank(excellentInnovation.getInnovationUuid())&&StringUtils.isNotBlank(tabModule.getModelUuid())){
			//执行修改业务操作	
			tabModule.setModifyDate(DateUtil.getCurrentTimstamp());
			baseDao.update(updateInnovation, excellentInnovation);
		}else{
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		tabModuleService.saveOrupdateTabmodule(tabModule);		
		
	}

	@Override
	public void deleteBusinessMethod(String uuids) {
		//删除模块信息
		tabModuleService.deleteTabModulebyUuids(uuids);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("ids", uuids.split(","));
		baseDao.delete(deleteInnovationByPrimaryKey, condition);
	}

	@Override
	public Map<String, Object> getInnovationByUuidBusinessMethod(String uuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("innovationUuid", uuid);
		Map<String, Object> innovationMap = (Map<String, Object>)baseDao.queryForObject(selectInnovationByPrimaryKey, condition);
		return innovationMap;
	}

	@Override
	public void executeAuditBusinessMethod(String uuids, String userId) {
		tabModuleService.executeAuditModule(uuids, userId);
	}

	@Override
	public void executeReleaseBusinessMethod(String uuids, String userId, Timestamp publishExpireDate) {
		TabModule module = new TabModule();
		module.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		module.setReleaseAccUuid(userId);
		module.setModifyAccUuid(userId);
		module.setPublishExpireDate(publishExpireDate);
		tabModuleService.executeReleaseModule(uuids, module);
		
	}
	
	@Override
	public void executeUndoBusinessMethod(String uuids, TabModule module) {
		tabModuleService.executeUndoTabModule(uuids, module);
	}
	
	public void deleteInnovationByDeptUuid(String deptUuids){
		//根据deptUUid删除优秀创新及模块信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("deptUuids", deptUuids.split(","));
		baseDao.delete(deleteInnovationByDeptUuid, condition);
	}

	@Override
	public Map<String, Object> getInnovationDetailToMobile(String uuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("innovationUuid", uuid);
		Map<String, Object> innovationMap = (Map<String, Object>)baseDao.queryForObject(selectInnovationByPrimaryKey, condition);
		return innovationMap;
	}

	@Override
	public MyPage queryInnovationListToMobile(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
			condition.putAll(myPage.getQueryParams());
		}
		return baseDao.getMyPage(myPage, excellentInnovationList, condition);
	}

}
