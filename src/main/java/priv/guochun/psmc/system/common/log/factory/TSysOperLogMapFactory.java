package priv.guochun.psmc.system.common.log.factory;

import java.util.HashMap;
import java.util.Map;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;

public class TSysOperLogMapFactory {
	
	private static TSysOperLogMapFactory factoy = new TSysOperLogMapFactory();
	
	private static Map<String,TSysOperLog> sysOperLogMap = new HashMap<String,TSysOperLog>();
	
	
	private TSysOperLogMapFactory(){
		
	}
	
	public static TSysOperLogMapFactory getInstance(){
		return factoy;
	}
	
	
	public Map<String,TSysOperLog> getTSysOperLog(){
		return sysOperLogMap;
	}
	
	
}
