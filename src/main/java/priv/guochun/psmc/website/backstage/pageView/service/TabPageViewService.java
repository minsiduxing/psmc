package priv.guochun.psmc.website.backstage.pageView.service;

import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;

public interface TabPageViewService {

	/**
	 * 新增或修改浏览量
	 * @param uuid
	 */
	public void saveOrUpdate(String uuid);
	
	/**
	 * 查询浏览量
	 * @param uuid
	 * @return
	 */
	public TabPageView queryPageviewByUuid(String uuid);
}
