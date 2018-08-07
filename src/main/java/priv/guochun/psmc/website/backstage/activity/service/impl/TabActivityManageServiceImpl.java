package priv.guochun.psmc.website.backstage.activity.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.user.dao.TabAccountDao;
import priv.guochun.psmc.authentication.user.dao.TabPersonDao;
import priv.guochun.psmc.system.enums.AccountTypeEnum;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.activity.model.TabActivityManage;
import priv.guochun.psmc.website.backstage.activity.model.TabSignUpInfo;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class TabActivityManageServiceImpl implements TabActivityManageService{

	private static final String selectActivityList = "selectActivityList";
	private static final String selectActivityByPrimaryKey = "selectActivityByPrimaryKey";
	private static final String deleteActivity = "deleteActivity";
	private static final String insertActivity = "insertActivity";
	private static final String updateActivity = "updateActivity";
	private static final String selectSignUpInfoList = "selectSignUpInfoList";
	private static final String selectSignUpInfoByPrimaryKey = "selectSignUpInfoByPrimaryKey";
	private static final String deleteSignUpInfoByAccount = "deleteSignUpInfoByAccount";
	private static final String insertSignUpInfo = "insertSignUpInfo";
	private static final String deleteActivityByDeptUuid = "deleteActivityByDeptUuid";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabModuleService tabModuleService;
	@Autowired
	private TabAccountDao tabAccountDao;
	@Autowired
	private TabPersonDao tabPersonDao;
	
	@Override
	public MyPage queryActivityList(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
			condition.putAll(myPage.getQueryParams());
		}
		return baseDao.getMyPage(myPage, selectActivityList, condition);
	}

	@Override
	public Map<String, Object> getActivityByUuid(String activityUuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("activityUuid", activityUuid);
		return (Map<String, Object>) baseDao.queryForObject(selectActivityByPrimaryKey, condition);
	}

	@Override
	public void addOrupdateActivity(TabActivityManage activity, TabModule tabModule) {
		if(null==activity || null == tabModule){
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		//判断是新增还是修改
		if(StringUtils.isBlank(activity.getActivityUuid())&&StringUtils.isBlank(tabModule.getModelUuid())){
			//执行模块初始化业务
			String uuid = UUIDGenerator.createUUID();
			tabModule.setModelUuid(uuid);
			tabModule.setCreateDate(DateUtil.getCurrentTimstamp());
			tabModule.setReleaseStatus(ModuleEnum.NOT_RELEASE.getValue());
			tabModule.setAudit(new Integer(ModuleEnum.NOT_AUDITED.getValue()));
			//添加活动
			activity.setActivityUuid(uuid);
			baseDao.insert(insertActivity, activity);
		}else if(StringUtils.isNotBlank(activity.getActivityUuid())&&StringUtils.isNotBlank(tabModule.getModelUuid())){
			//执行修改业务操作	
			tabModule.setModifyDate(DateUtil.getCurrentTimstamp());
			baseDao.update(updateActivity, activity);
		}else{
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		tabModuleService.saveOrupdateTabmodule(tabModule);	
		
	}

	@Override
	public void deleteActivity(String activityUuids) {
		//删除模块信息
		tabModuleService.deleteTabModulebyUuids(activityUuids);
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("activityUuids", activityUuids.split(","));
		baseDao.delete(deleteActivity, condition);
	}

	@Override
	public void executeAudit(String activityUuids, String userId) {
		tabModuleService.executeAuditModule(activityUuids, userId);
	}

	@Override
	public void executeRelease(String activityUuids, String userId, Timestamp publishExpireDate) {
		TabModule module = new TabModule();
		module.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		module.setReleaseAccUuid(userId);
		module.setModifyAccUuid(userId);
		module.setPublishExpireDate(publishExpireDate);
		tabModuleService.executeReleaseModule(activityUuids, module);
		
	}
	
	@Override
	public void deleteActivityByDeptUuid(String deptUuids){
		//根据deptUUid删除活动、报名及模块信息
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("deptUuids", deptUuids.split(","));
		baseDao.delete(deleteActivityByDeptUuid, condition);
	}

	@Override
	public void addSignUpInfo(String activityUuid, String accout) {
		Map<String, Object> signUpMap = this.getSignUpByActivityIdAndAccout(activityUuid, accout);
		if(signUpMap != null && signUpMap.size() > 0){
			throw new PsmcBuisnessException("已经报名不能重复报名");
		}
		Map<String, Object> activity = this.getActivityByUuid(activityUuid);
		if(activity == null || activity.size() == 0){
			throw new PsmcBuisnessException("活动信息不存在！");
		}
		if(DateUtil.getCurrentTimstamp().after(DateUtil.getTime(activity.get("sign_up_end_date").toString()))){
			throw new PsmcBuisnessException("已过报名截止时间！");
		}
		Map<?,?> accountMap = tabAccountDao.getTabAccountByPhone(accout,AccountTypeEnum.WECHAT_USER.getValue().intValue());
     	if(accountMap == null || accountMap.get("UUID") == null){
     		throw new PsmcBuisnessException("用户信息不存在！");
     	}
     	Map<?,?> personMap = tabPersonDao.getTabPersonByAccountId(accountMap.get("UUID").toString());
		TabSignUpInfo signUp = new TabSignUpInfo();
		signUp.setSignUpUuid(UUIDGenerator.createUUID());
		signUp.setActivityUuid(activityUuid);
		signUp.setPersonAccount(accout);
		signUp.setPersonName(String.valueOf(personMap.get("PERSON_NAME")));
		signUp.setPersonMobile(String.valueOf(personMap.get("TELEPHONE")));
		signUp.setSignUpDate(DateUtil.getCurrentTimstamp());
		baseDao.insert(insertSignUpInfo, signUp);
		
	}

	@Override
	public void deleteSignInfo(String activityUuid, String accout) {
		Map<String, Object> activity = this.getActivityByUuid(activityUuid);
		if(activity == null || activity.size() == 0){
			throw new PsmcBuisnessException("活动信息不存在！");
		}
		if(DateUtil.getCurrentTimstamp().after(DateUtil.getTime(activity.get("sign_up_end_date").toString()))){
			throw new PsmcBuisnessException("报名截止时间已过，不能取消！");
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("personAccount", accout);
		condition.put("activityUuid", activityUuid);
		baseDao.delete(deleteSignUpInfoByAccount, condition);
	}

	@Override
	public List<Map<String, Object>> querySignUpInfoList(String activityUuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("activityUuid", activityUuid);
		return baseDao.queryForList(selectSignUpInfoList, condition) ;
	}

	@Override
	public Map<String, Object> getSignUpByActivityIdAndAccout(String activityUuid, String accout){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("personAccount", accout);
		condition.put("activityUuid", activityUuid);
		return (Map<String, Object>) baseDao.queryForObject(selectSignUpInfoList, condition);
	}

	@Override
	public void executeUndoBusinessMethod(String activityUuids, TabModule module) {
		tabModuleService.executeUndoTabModule(activityUuids, module);
	}
	
}
