package priv.guochun.psmc.system.framework.sms.core;


import java.util.Properties;

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


	public MsgModel sendSms(SmsModel smsModel){
		Properties pp = SystemPropertiesUtil.getProps();
		//短信是否开启
		boolean sms_enable =Boolean.parseBoolean(pp.getProperty("sms_enable"));
		MsgModel mm = null;
		if(sms_enable)
			mm = smsSendModeSrategy.sendSms(smsModel.getReceiveNo(),smsModel.getReceiveContext());
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
	     
//	     sysOperLog.setOperInput(GsonUtil.toJsonForObject(smsModel));
	     sysOperLog.setOperOutput(GsonUtil.toJsonForObject(mm));
	     sysOperLog.setOperResult(true == mm.isSuccess()?LogResultEnum.success.getIndex():LogResultEnum.error.getIndex());
	     sysOperLog.setOperResultDesc("系统发送短信日志记录!");
	     TSysOperLogMapFactory.getInstance().getTSysOperLog().put(sysOperLog.getUuid(), sysOperLog);
	     return mm;
	     
	}

}
