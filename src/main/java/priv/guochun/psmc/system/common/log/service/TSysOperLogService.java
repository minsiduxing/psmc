package priv.guochun.psmc.system.common.log.service;

import org.json.JSONObject;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;

public interface TSysOperLogService {
	
	public JSONObject save(TSysOperLog tTSysOperLog);
}
