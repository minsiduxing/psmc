package priv.guochun.psmc.system.framework.sms.core;


import java.util.Map;

import priv.guochun.psmc.system.framework.sms.model.SmsModel;


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


	public void sendSms(SmsModel smsModel){
		Map<String,Object> map = smsSendModeSrategy.sendSms(smsModel.getReceiveNo(),smsModel.getReceiveContext());
		boolean flag = Boolean.getBoolean(map.get("flag").toString());
		String returnmsg = map.get("returnmsg")!=null?map.get("returnmsg").toString():"";
		//todo 这里可以统一处理短信的重发机制、日志记录等
	}

}
