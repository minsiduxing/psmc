package priv.guochun.psmc.system.framework.sms.service.impl;

import java.util.Properties;

import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.core.SmsSendRuleSolve;
import priv.guochun.psmc.system.framework.sms.factory.DefaultSmsModeBuildFactory;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;

public class BaseMobileSmsSendServiceImpl implements MobileSmsSendService {

    private SmsSendRuleSolve smsSendRuleSolve = null;
    
    
    
    
	@Override
	public MsgModel sendSms(SmsModel smsModel) {
	    Properties pp = SystemPropertiesUtil.getProps();
        String sms_model =pp.getProperty("sms_model");
        if("xasjhc".equals(sms_model)){
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createChuangXinSsm());
            return smsSendRuleSolve.sendSms(smsModel);
        }else if("sczgyj".equals(sms_model)){
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createDefaultAlSsm());
        }else
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createChuangXinSsm());
	    
		return smsSendRuleSolve.sendSms(smsModel);
	}


    public void setSmsSendRuleSolve(SmsSendRuleSolve smsSendRuleSolve)
    {
        this.smsSendRuleSolve = smsSendRuleSolve;
    }

	
	
	
	
}
