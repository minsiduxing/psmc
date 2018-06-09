package priv.guochun.psmc.system.framework.sms.service;

import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;


public interface MobileSmsSendService {

	/**
	 * 发送一条短信
	 * @param mobile 手机号
	 * @param content 短信内容
	 */
	public MsgModel sendSms(SmsModel smsModel);
	

}
