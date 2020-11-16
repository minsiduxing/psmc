package priv.guochun.psmc.system.framework.sms.core;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.cache.Cache;
import priv.guochun.psmc.system.common.log.factory.TSysOperLogMapFactory;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.framework.util.LogResultEnum;
import priv.guochun.psmc.system.framework.util.LogTypeEnum;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;

import java.util.Map;


/**
 * 短信发送模式动态切换类
 * @author Administrator
 *
 */

public class SmsSendRuleSolve
{
	
    private static Logger logger = Logger.getLogger(SmsSendRuleSolve.class);
    
	/**
	 * 具体发送短信的算法类
	 */
	private SmsSendAbstractMode smsSendModeSrategy;
	
	
	public SmsSendRuleSolve(SmsSendAbstractMode smsSendAbstractMode){
		this.smsSendModeSrategy = smsSendAbstractMode;
	}
	
	public SmsSendAbstractMode getSmsSendModeSrategy() {
		return smsSendModeSrategy;
	}

	public void setSmsSendModeSrategy(SmsSendAbstractMode smsSendModeSrategy) {
		this.smsSendModeSrategy = smsSendModeSrategy;
	}

	private SmsSendRuleSolve(){
	    
	}
	
	public static SmsSendRuleSolve createInstance(){
	    SmsSendRuleSolve solve  = new SmsSendRuleSolve();
	    return solve;
	}
	

	public MsgModel sendSms(SmsModel smsModel){
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String sms_enable =map.get("sms_enable").toString();
		MsgModel mm = null;
		try{
		    if(Boolean.getBoolean(sms_enable))
		    	if(StringUtils.isNotBlank(smsModel.getSendType())) {
		    		mm = smsSendModeSrategy.sendSms(smsModel);
		    	}else {
		    		mm = MsgModel.buildDefaultError("发送类型为空");
		    	}
	        else
	            mm = MsgModel.buildDefaultSuccess("模拟短信发送成功:"+smsModel.getReceiveContext(),null);
		    
		     //todo 这里可以统一处理短信的重发机制、日志记录等
	         TSysOperLog sysOperLog = new TSysOperLog();
	         sysOperLog.setUuid(UUIDGenerator.createUUID());
	         sysOperLog.setLogType(LogTypeEnum.LogTypeSysOper3.getIndex());
	         sysOperLog.setLogTypeName(LogTypeEnum.LogTypeSysOper3.getName());
	         sysOperLog.setLogSubType(LogTypeEnum.LogTypeSysOper3_1.getIndex());
	         sysOperLog.setLogSubTypeName(LogTypeEnum.LogTypeSysOper3_1.getName());
	         sysOperLog.setOperDate(DateUtil.getCurrentTimstamp());
	         
	         sysOperLog.setOperInput(smsModel.getReceiveContext());
	         sysOperLog.setOperOutput(GsonUtil.toJsonForObject(mm));
	         sysOperLog.setOperResult(true == mm.isSuccess()?LogResultEnum.success.getIndex():LogResultEnum.error.getIndex());
	         sysOperLog.setOperResultDesc("系统发送短信日志记录!");
	         sysOperLog.setBussinessUuid(smsModel.getReceiveNo());
	         TSysOperLogMapFactory.getInstance().getTSysOperLog().put(sysOperLog.getUuid(), sysOperLog);
	         return mm;
		}catch(Exception e){
		    String msg = "调用短信发送服务异常 "+e;
		    logger.error(msg);
		    return MsgModel.buildDefaultError(msg);
		}
		
	}
	//查询余额
	public String getBalance(String sendType){
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String sms_enable =map.get("sms_enable").toString();
		String balance = "0";
		try{
			if(Boolean.getBoolean(sms_enable))
				if(StringUtils.isNotBlank(sendType)) {
					balance = smsSendModeSrategy.getBalance(sendType);
				}
			
			//todo 这里可以统一处理短信的重发机制、日志记录等
			TSysOperLog sysOperLog = new TSysOperLog();
			sysOperLog.setUuid(UUIDGenerator.createUUID());
			sysOperLog.setLogType(LogTypeEnum.LogTypeSysOper3.getIndex());
			sysOperLog.setLogTypeName(LogTypeEnum.LogTypeSysOper3.getName());
			sysOperLog.setLogSubType(LogTypeEnum.LogTypeSysOper3_1.getIndex());
			sysOperLog.setLogSubTypeName(LogTypeEnum.LogTypeSysOper3_1.getName());
			sysOperLog.setOperDate(DateUtil.getCurrentTimstamp());
			
			sysOperLog.setOperInput("");
			sysOperLog.setOperOutput(balance);
			sysOperLog.setOperResult(null);
			sysOperLog.setOperResultDesc("系统发送短信日志记录!");
			sysOperLog.setBussinessUuid("");
			TSysOperLogMapFactory.getInstance().getTSysOperLog().put(sysOperLog.getUuid(), sysOperLog);
			return balance;
		}catch(Exception e){
			String msg = "调用短信查询余额服务异常 "+e;
			logger.error(msg);
			return null;
		}
		
	}
}
