package priv.guochun.psmc.website.backstage.news.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;
import priv.guochun.psmc.website.backstage.news.dao.TabNewsDao;
import priv.guochun.psmc.website.backstage.news.model.TabNews;
import priv.guochun.psmc.website.backstage.news.service.TabNewsService;
import priv.guochun.psmc.website.enums.ModuleEnum;

public class TabNewsServiceImpl implements TabNewsService {
	protected static final  Logger logger  = LoggerFactory.getLogger(TabNewsServiceImpl.class);
	@Autowired
	private TabModuleService tabModuleService;
	@Autowired
	private TabNewsDao tabNewsDao;
	@Override
	public void saveOrUpdateTabNewsBusinessMethod(TabNews tabNews, TabModule tam) {
		if(null==tabNews || null == tam){
			throw new PsmcBuisnessException("保存新闻参数出错！");
		}
		//判断是新增还是修改
		if(StringUtils.isBlank(tabNews.getNewsUuid())&&StringUtils.isBlank(tam.getModelUuid())){
			//执行模块初始化业务
			String uuid = UUIDGenerator.createUUID();
			tam.setModelUuid(uuid);
			tam.setCreateDate(DateUtil.getCurrentTimstamp());
			tam.setOneLevelClassify(ModuleEnum.ONE_LEVEL_CLASSIFY_NEWS.getValue());
			tam.setReleaseStatus(ModuleEnum.NOT_RELEASE.getValue());
			tam.setAudit(new Integer(ModuleEnum.NOT_AUDITED.getValue()));
			//执行新闻初始化业务
			tabNews.setNewsUuid(uuid);
		}else if(StringUtils.isNotBlank(tabNews.getNewsUuid())&&StringUtils.isNotBlank(tam.getModelUuid())){
			//执行修改业务操作	
			tam.setModifyDate(DateUtil.getCurrentTimstamp());
		}else{
			throw new PsmcBuisnessException("保存新闻参数出错！");
		}
				
		//1.保存或者修改模块相关信息
		tabModuleService.saveOrupdateTabmodule(tam);
		//2.保存模块相关信息
		tabNewsDao.saveOrUpdateTabNews(tabNews);
	}

	@Override
	public void deleteTabNewsByUuidsBusinessMethod(String uuids) {
       // 先删除模块信息
		tabModuleService.deleteTabModulebyUuids(uuids);
		//删除模块信息
		tabNewsDao.deleteTabNewsByUuids(uuids);
	}

	@Override
	public Map<String, Object> getNewsByNewsUuid(String uuid) {
		return tabNewsDao.getNewsByNewsUuid(uuid);
	}

	@Override
	public MyPage getNewsByConditionBusinessMethod(MyPage myPage) {
		return tabNewsDao.getNewsByCondition(myPage);
	}

	@Override
	public List<Map<String, Object>> getNewsListByConditionBusinessMethod(MyPage myPage) {
		return tabNewsDao.getNewsListByCondition(myPage);
	}

	@Override
	public List<Map<String, Object>> getShowNewsTitlesListByTowLevelClassify(
			String towLevelClassify) {
		return tabNewsDao.getShowNewsTitlesListByTowLevelClassify(towLevelClassify);
	}

	@Override
	public void executeAuditNewsBusinessMethod(TabModule tam) {
		// 审核
		tabModuleService.executeAuditModule(tam);
		
	}

	@Override
	public void executeReleaseNewsBusinessMethod(TabModule tam) {
		// 发布信息
		tabModuleService.executeReleaseModule(tam);
		
	}

	@Override
	public void executeCancleReleaseNewsBusinessMethod(TabModule tam) {
		//取消发布新闻
		tabModuleService.executeReleaseCancel(tam);
		
	}

	@Override
	public MyPage getNewsByCondition(MyPage myPage, String userUuid) {
		return tabNewsDao.getNewsByCondition(myPage,userUuid);
	}

	

}
