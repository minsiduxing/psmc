package priv.guochun.psmc.system.framework.sms.service.impl;

import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.core.SmsSendRuleSolve;
import priv.guochun.psmc.system.framework.sms.factory.DefaultSmsModeBuildFactory;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;

public class ChjghMobileSmsSendServiceImpl implements MobileSmsSendService {

	@Override
	public MsgModel sendSms(SmsModel smsModel) {
		SmsSendRuleSolve solve = new SmsSendRuleSolve(DefaultSmsModeBuildFactory.getInstance().createDefaultAlSsm());
		return solve.sendSms(smsModel);
	}

}
