package priv.guochun.psmc.website.backstage.laud.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.user.dao.TabPersonDao;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.laud.model.TabLaud;
import priv.guochun.psmc.website.backstage.laud.service.TabLaudService;

public class TabLaudServiceImpl implements TabLaudService {

	private static final String selectLaudList = "selectLaudList";
	private static final String deleteLaud = "deleteLaud";
	private static final String insertLaud = "insertLaud";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabPersonDao tabPersonDao;
	
	@Override
	public MyPage queryLaudList(MyPage myPage){
		Map<String, Object> condition = myPage.getQueryParams();
		if(condition == null){
			condition = new HashMap<String, Object>();
		}
		return baseDao.getMyPage(myPage, selectLaudList, condition);
	}
	
	@Override
	public void addLaud(String moduleUuid, String laudPersonUuid){
		TabLaud laud = new TabLaud();
		laud.setLaudUuid(UUIDGenerator.createUUID());
		laud.setModuleUuid(moduleUuid);
		laud.setLaudPersonUuid(laudPersonUuid);
		laud.setLaudDate(DateUtil.getCurrentTimstamp());
		Map<String, Object> personMap = tabPersonDao.getTabPersonByUuid(laudPersonUuid);
		if(personMap != null){
			laud.setLaudPersonName((String)personMap.get("PERSON_NAME"));
		}
		baseDao.insert(insertLaud, laud);
	}
	
	@Override
	public void deleteLaud(String moduleUuid, String laudPersonUuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("moduleUuid", moduleUuid);
		condition.put("laudPersonUuid", laudPersonUuid);
		baseDao.delete(deleteLaud, condition);
	}
	
	@Override
	public boolean selectIsLaud(String moduleUuid, String laudPersonUuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("moduleUuid", moduleUuid);
		condition.put("laudPersonUuid", laudPersonUuid);
		Map<String, Object> laudMap = (Map<String, Object>) baseDao.queryForObject(selectLaudList, condition);
		if(laudMap != null && laudMap.size() > 0){
			return true;
		}else{
			return false;
		}
	}
}
