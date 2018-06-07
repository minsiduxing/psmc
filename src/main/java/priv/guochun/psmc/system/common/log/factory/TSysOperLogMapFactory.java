package priv.guochun.psmc.system.common.log.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;

public class TSysOperLogMapFactory {
	
	private static TSysOperLogMapFactory factoy = new TSysOperLogMapFactory();
	
	private static Map<String,TSysOperLog> sysOperLogMap = new HashMap<String,TSysOperLog>();
	
	@SuppressWarnings("rawtypes")
	private static Queue queue = new ConcurrentLinkedQueue();
	
	private TSysOperLogMapFactory(){
		
	}
	
	
	public static TSysOperLogMapFactory getInstance(){
		return factoy;
	}
	
	
	public Map<String,TSysOperLog> getTSysOperLog(){
		return sysOperLogMap;
	}
	
	@SuppressWarnings("rawtypes")
	public Queue getTSysOperLogQueue(){
		return queue;
	}
	
}
