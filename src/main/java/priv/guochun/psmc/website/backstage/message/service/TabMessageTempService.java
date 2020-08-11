package priv.guochun.psmc.website.backstage.message.service;

import java.util.List;

import priv.guochun.psmc.website.backstage.message.model.TabMessageTemp;

public interface  TabMessageTempService {
	
	/**
	 * 根据code查询
	 * @return
	 */
	public  TabMessageTemp queryByTempCode(String tempCode);
	/**
	 * 查询所有短信模板
	 * @return
	 */
	public List<TabMessageTemp> queryByTempCodeList();
}
