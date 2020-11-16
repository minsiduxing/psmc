package priv.guochun.psmc.system.framework.sms.service.impl;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import priv.guochun.psmc.system.common.sysConfig.model.TabSysConfig;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.core.SmsSendRuleSolve;
import priv.guochun.psmc.system.framework.sms.factory.DefaultSmsModeBuildFactory;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;

public class BaseMobileSmsSendServiceImpl implements MobileSmsSendService {

    private SmsSendRuleSolve smsSendRuleSolve = null;
    @Autowired
	private PsmcCacheFactory psmcCacheFactory;
    
    
    
	@Override
	public MsgModel sendSms(SmsModel smsModel) {
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String sms_channel =map.get("sms_channel").toString();
        if("xasjhc".equals(sms_channel)){
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createZhongYiSsm());
            return smsSendRuleSolve.sendSms(smsModel);
        }else if("sczgyj".equals(sms_channel)){
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createDefaultAlSsm());
        }else
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createZhongYiSsm());
	    
		return smsSendRuleSolve.sendSms(smsModel);
	}

	
    public void setSmsSendRuleSolve(SmsSendRuleSolve smsSendRuleSolve)
    {
        this.smsSendRuleSolve = smsSendRuleSolve;
    }


	@Override
	public String getBalance(String sendType) {
		Properties pp = SystemPropertiesUtil.getProps();
		String sms_model =pp.getProperty("sms_model");
		if("xasjhc".equals(sms_model)){
            smsSendRuleSolve.setSmsSendModeSrategy(DefaultSmsModeBuildFactory.getInstance().createZhongYiSsm());
            return smsSendRuleSolve.getBalance(sendType);
        }
		return null;
	}
	
}
