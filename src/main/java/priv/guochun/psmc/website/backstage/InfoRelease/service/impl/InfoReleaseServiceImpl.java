package priv.guochun.psmc.website.backstage.InfoRelease.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoRelease;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class InfoReleaseServiceImpl implements InfoReleaseService{

	public static final String getInfoReleaseList="getInfoReleaseList";
    public static final String getInfoReleaseByUuid="getInfoReleaseByUuid";
    public static final String insertInfoRelease="insertInfoRelease";
    public static final String updateInfoRelease="updateInfoRelease";
    public static final String deletesInfoReleaseByUuid="deletesInfoReleaseByUuid";
    
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TabModuleService tabModuleService;
	@Override
	public void saveOrUpdateInfoReleaseBusinessMethod(InfoRelease infoRelease, TabModule tabModule) {
		if(null==infoRelease || null == tabModule){
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		//判断是新增还是修改
		if(StringUtils.isBlank(infoRelease.getNewsUuid())&&StringUtils.isBlank(tabModule.getModelUuid())){
			//执行模块初始化业务
			String uuid = UUIDGenerator.createUUID();
			tabModule.setModelUuid(uuid);
			tabModule.setCreateDate(DateUtil.getCurrentTimstamp());
			tabModule.setReleaseStatus(ModuleEnum.NOT_RELEASE.getValue());
			tabModule.setAudit(new Integer(ModuleEnum.NOT_AUDITED.getValue()));
			//执行新闻初始化业务
			infoRelease.setNewsUuid(uuid);
			baseDao.insert(insertInfoRelease, infoRelease);
		}else if(StringUtils.isNotBlank(infoRelease.getNewsUuid())&&StringUtils.isNotBlank(tabModule.getModelUuid())){
			//执行修改业务操作	
			tabModule.setModifyDate(DateUtil.getCurrentTimstamp());
			baseDao.update(updateInfoRelease, infoRelease);
		}else{
			throw new PsmcBuisnessException("保存信息参数出错！");
		}
		tabModuleService.saveOrupdateTabmodule(tabModule);		
		
	}
	
	@Override
	public void deleteInfoReleaseByUuidsBusinessMethod(String uuids) {
		//删除模块信息
		tabModuleService.deleteTabModulebyUuids(uuids);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("ids", uuids.split(","));
		baseDao.delete(deletesInfoReleaseByUuid, condition);
	}
	
	@Override
	public Map<String, Object> getInfoReleaseByUuidBusinessMethod(String uuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("newsUuid", uuid);
		return (Map<String, Object>) baseDao.queryForObject(getInfoReleaseByUuid, condition);
	}
	
	@Override
	public MyPage getInfoReleaseListBusinessMethod(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
			condition.putAll(myPage.getQueryParams());
		}
		return baseDao.getMyPage(myPage, getInfoReleaseList, condition);
	}

	@Override
	public void executeAuditModuleBusinessMethod(String newsIds, String userId) {
		tabModuleService.executeAuditModule(newsIds, userId);
	}

	@Override
	public void executeReleaseModuleBusinessMethod(String newsIds, String userId, Timestamp publishExpireDate) {
		TabModule module = new TabModule();
		module.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		module.setReleaseAccUuid(userId);
		module.setModifyAccUuid(userId);
		module.setPublishExpireDate(publishExpireDate);
		tabModuleService.executeReleaseModule(newsIds, module);
	}

	@Override
	public Map<String, Object> getInfoDetailToMobile(String uuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("newsUuid", uuid);
		return (Map<String, Object>) baseDao.queryForObject(getInfoReleaseByUuid, condition);
	}

	@Override
	public MyPage queryInfoListToMobile(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
			condition.putAll(myPage.getQueryParams());
		}
		return baseDao.getMyPage(myPage, getInfoReleaseList, condition);
	}
	public Map<String,Object> getInfoDetailToMobile(Map<String, Object> paramMap){
		return (Map<String, Object>) baseDao.queryForObject(getInfoReleaseByUuid, paramMap);
	}
	@Override
	public void executeUndoBusinessMethod(String uuids, TabModule module) {
		tabModuleService.executeUndoTabModule(uuids, module);
	}
    
}
