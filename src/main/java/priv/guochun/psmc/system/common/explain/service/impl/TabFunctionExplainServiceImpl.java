package priv.guochun.psmc.system.common.explain.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.common.explain.model.TabFunctionExplain;
import priv.guochun.psmc.system.common.explain.service.TabFunctionExplainService;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;

public class TabFunctionExplainServiceImpl implements TabFunctionExplainService {

	private static final String selectFunctionExplain = "selectFunctionExplain";
	private static final String deleteFunctionExplain = "deleteFunctionExplain";
	private static final String insertFunctionExplain = "insertFunctionExplain";
	private static final String updateFunctionExplain = "updateFunctionExplain";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public void addOrUpdateExplain(TabFunctionExplain explain) {
		if(explain == null){
			throw new PsmcBuisnessException("参数不合法!");
		}
		if(StringUtils.isBlank(explain.getExplainUuid())){
			explain.setExplainUuid(UUIDGenerator.createUUID());
			baseDao.insert(insertFunctionExplain, explain);
		}else{
			baseDao.update(updateFunctionExplain, explain);
		}
	}

	@Override
	public void deleteExplain(String explainUuid) {
		baseDao.delete(deleteFunctionExplain, explainUuid);

	}

	@Override
	public TabFunctionExplain queryExplainByCode(String functionCode) {
		TabFunctionExplain explain = (TabFunctionExplain) baseDao.queryForObject(selectFunctionExplain, functionCode);
		return explain;
	}

}
