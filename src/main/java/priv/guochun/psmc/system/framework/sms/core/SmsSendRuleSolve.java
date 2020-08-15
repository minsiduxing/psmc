package priv.guochun.psmc.system.framework.sms.core;


import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import priv.guochun.psmc.system.common.log.factory.TSysOperLogMapFactory;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.framework.util.LogResultEnum;
import priv.guochun.psmc.system.framework.util.LogTypeEnum;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;


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
		Properties pp = SystemPropertiesUtil.getProps();
		MsgModel mm = null;
		try{
		    //短信是否开启
	        boolean sms_enable =Boolean.parseBoolean(pp.getProperty("sms_enable"));
		    if(sms_enable)
		    	if(StringUtils.isNotBlank(smsModel.getSendType())) {
		    		mm = smsSendModeSrategy.sendSms(smsModel);
		    	}else {
		    		mm = MsgModel.buildDefaultSuccess("发送类型为空",null);
		    	}
	        else
	            mm = MsgModel.buildDefaultSuccess("非生产环境模拟短信发送成功:"+smsModel.getReceiveContext(),null);
		    
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
}
