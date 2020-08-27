package priv.guochun.psmc.system.framework.sms.core;

import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;


/**
 * 短信发送模式抽象类
 * @author Administrator
 *
 */

public abstract class SmsSendAbstractMode
{
	/**
	 * 发送一条短信
	 * @param mobile 手机号
	 * @param content 短息内容
	 * @return {flag:true,returnmsg:value}
	 * flag:短信发送成功失败标识 returnmsg:接口调用返回信息 
	 */
	public abstract MsgModel sendSms(SmsModel smsModel);
	/**
	 * 查询余额
	 * @param sendType 短信类型（0短信、1彩信、2个性化短信）
	 * @return
	 */
	public abstract String getBalance(String sendType);
}
