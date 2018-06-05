package priv.guochun.psmc.system.common.log.service.impl;

import org.json.JSONObject;

import priv.guochun.psmc.system.common.log.dao.TSysOperLogDao;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.common.log.service.TSysOperLogService;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.util.ReturnModel;

public class TSysOperLogServiceImpl implements TSysOperLogService {

	private TSysOperLogDao tSysOperLogDao;
	
	public JSONObject save(TSysOperLog tTSysOperLog){
		int flag = tSysOperLogDao.save(tTSysOperLog);
		if(flag>0)
			return ReturnModel.createSuccessJSONObject("日志保存成功");
		else
			return ReturnModel.createFailJSONObject("日志保存失败");
	}
	
	public MyPage getMyPageOfTSysOperLog(MyPage myPage){
		return tSysOperLogDao.getMyPageOfTSysOperLog(myPage);
	}
	
	public TSysOperLogDao gettSysOperLogDao() {
		return tSysOperLogDao;
	}

	public void settSysOperLogDao(TSysOperLogDao tSysOperLogDao) {
		this.tSysOperLogDao = tSysOperLogDao;
	}
	
	
}
