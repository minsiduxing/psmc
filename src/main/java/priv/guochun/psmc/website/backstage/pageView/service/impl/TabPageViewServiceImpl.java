package priv.guochun.psmc.website.backstage.pageView.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;
import priv.guochun.psmc.website.backstage.pageView.service.TabPageViewService;

public class TabPageViewServiceImpl implements TabPageViewService{

	private static final String getPageViewByUuid = "getPageViewByUuid";
	private static final String insertPageView = "insertPageView";
	private static final String updatePageView = "updatePageView";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public void saveOrUpdate(String uuid) {
		TabPageView pageView = this.queryPageviewByUuid(uuid);
		if(pageView == null){
			pageView = new TabPageView();
			pageView.setUuid(uuid);
			pageView.setNums(1);
			baseDao.insert(insertPageView, pageView);
		}else{
			pageView.setNums(pageView.getNums() + 1);
			baseDao.update(updatePageView, pageView);
		}
		
	}

	@Override
	public TabPageView queryPageviewByUuid(String uuid) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("uuid", uuid);
		return (TabPageView) baseDao.queryForObject(getPageViewByUuid, condition);
	}

}
