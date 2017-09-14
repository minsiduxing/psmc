package priv.guochun.psmc.website.backstage.module.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.module.dao.TabModuleDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.backstage.modulepublish.model.TabModulePublish;
import priv.guochun.psmc.website.backstage.modulepublish.service.TabModulePublishService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class TabModuleServiceImpl implements TabModuleService {
	protected static final  Logger logger  = LoggerFactory.getLogger(TabModuleService.class);
	@Autowired
	private TabModuleDao tabModuleDao;
	@Autowired
	private TabModulePublishService tabModulePublishService;
	@Override
	public void saveOrupdateTabmodule(TabModule tam) {
		tabModuleDao.saveOrUpdateTabModule(tam);
	}

	@Override
	public void deleteTabModulebyUuids(String ids) {
		List<TabModule> modeuls = tabModuleDao.getModulesByUuids(ids);
		List<TabModulePublish>  tamps = tabModulePublishService.getTabModulePublishsByModuleids(ids);
		//判断模块是否存在
		if(null==modeuls){
			throw new PsmcBuisnessException("删除的模块不存在不能删除");
		}
		//判断是否已经发布
		if(null!=tamps && tamps.size()>=1){
			for(TabModulePublish tamp:tamps){
				//判断所发布的模块中是否存在到期的模块
				if(DateUtil.getCurrentTimstamp().before(tamp.getPublishExpireDate())){
					throw new PsmcBuisnessException("存在已发布且未到期的模块不能删除！");
				}
			}
		}else{
			tabModulePublishService.deleteTabModulePublishByids(ids);
			tabModuleDao.deleteTabModule(ids);
		}
	}

	@Override
	public void executeAuditModule(TabModule tm) {
		if(StringUtils.isBlank(tm.getModelUuid())){
			throw new PsmcBuisnessException("参数有误！");
		}
		// 1.判断模块是否存在如果不存在则不能审核
		TabModule temp = tabModuleDao.getModuleByUuid(tm.getModelUuid());
		if(null==temp){
			throw new PsmcBuisnessException("模块不存在不能审核");
		}
		// 2.判断模块是否为审核通过如果审核通过则不能审核
		if(ModuleEnum.AUDITED_PASS.equals(temp.getAudit())){
			throw new PsmcBuisnessException("模块已经审核通过不能审核");		
		}
		// 3.判断模块是否为已发布状态若为已发布则不能审核
		if(ModuleEnum.IS_RELEASEED.equals(temp.getReleaseStatus())){
			throw new PsmcBuisnessException("模块已经发布不能审核");		
		}
		//更新审核通过标示
		temp.setAudit(tm.getAudit());
		temp.setAuditDate(DateUtil.getCurrentTimstamp());
		temp.setAuditAccUuid(tm.getAuditAccUuid());
		//4.修改模块状态
		tabModuleDao.saveOrUpdateTabModule(temp);
	}
	@Override
	public void executeReleaseModule(TabModule tm) {
		if(null==tm){
			throw new PsmcBuisnessException("参数有误！");
		}
		// 1.判断模块是否存在如果不存在则不能发布
		TabModule temp = tabModuleDao.getModuleByUuid(tm.getModelUuid());
		if(null==temp){
			throw new PsmcBuisnessException("模块不存在不能发布");
		}
		// 2.判断模块是否为审核通过如果审核不通过通过则不能发布
		if(new Integer(ModuleEnum.AUDITED_PASS.getValue())==temp.getAudit()){
			throw new PsmcBuisnessException("模块未审核通过或者未审核不能发布");		
		}
		// 3.判断模块是否为已发布状态若为已发布则不能发布
		if(ModuleEnum.IS_RELEASEED.equals(temp.getReleaseStatus())){
			throw new PsmcBuisnessException("模块已经发布不能再次发布");		
		}
		//4.新增模块发布信息
		TabModulePublish tmp = new TabModulePublish();
		tmp.setPblishUuid(UUIDGenerator.createUUID());
		tmp.setModuleUuuid(temp.getModelUuid());
		tmp.setPublishAccountUuid(tm.getReleaseAccUuid());
		tmp.setPublishDate(DateUtil.getCurrentTimstamp());
		tmp.setPublishExpireDate(tm.getPublishExpireDate());
		tabModulePublishService.saveOrUpdateTabModulePublish(tmp);
		//更新模块信息
		temp.setReleaseDate(tmp.getPublishDate());
		temp.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		temp.setReleaseAccUuid(tm.getReleaseAccUuid());
		tabModuleDao.saveOrUpdateTabModule(temp);
	}

	@Override
	public void executeReleaseCancel(TabModule tm) {
		if(null==tm){
			throw new PsmcBuisnessException("参数有误！");
		}
		// 1.判断模块是否存在如果不存在则不能取消发布
		TabModule temp = tabModuleDao.getModuleByUuid(tm.getModelUuid());
		if(null==temp){
			throw new PsmcBuisnessException("模块不存在不能取消发布");
		}
		// 2.判断模块是否为审核通过如果审核不通过通过则不能取消发布
		if(!ModuleEnum.AUDITED_PASS.equals(temp.getAudit())){
			throw new PsmcBuisnessException("模块未审核通过或者未审核不能取消发布");		
		}
		// 3.判断模块是否为未发布状态则不能取消发布
		if(!ModuleEnum.IS_RELEASEED.equals(temp.getReleaseStatus())){
			throw new PsmcBuisnessException("模块还未发布不能取消发布");		
		}
		//4.删除发布信息
		tabModulePublishService.deleteTabModulePublishByModuleids(tm.getModelUuid());
		//5.修改模块状态
		tm.setReleaseStatus(ModuleEnum.NOT_RELEASE.getValue());
		//发布人置为null
		tm.setReleaseAccUuid(null);
		//发布日期置为null
		tm.setReleaseDate(null);
		tabModuleDao.saveOrUpdateTabModule(tm);
	}

}
