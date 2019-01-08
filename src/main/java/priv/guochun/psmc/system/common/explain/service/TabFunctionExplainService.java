package priv.guochun.psmc.system.common.explain.service;

import priv.guochun.psmc.system.common.explain.model.TabFunctionExplain;

/**
 * 功能说明服务类
 * @author Administrator
 *
 */
public interface TabFunctionExplainService {

	public String addOrUpdateExplain(TabFunctionExplain explain);
	
	public void deleteExplain(String explainUuid);
	
	public TabFunctionExplain queryExplainByCode(String functionCode);
}
