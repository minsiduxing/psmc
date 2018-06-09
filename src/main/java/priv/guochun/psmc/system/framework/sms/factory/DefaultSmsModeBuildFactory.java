package priv.guochun.psmc.system.framework.sms.factory;

import java.util.Properties;

import priv.guochun.psmc.system.framework.sms.core.SmsSendAbstractMode;
import priv.guochun.psmc.system.framework.sms.core.impl.DefaultAliyunSmsSendMode;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;

public class DefaultSmsModeBuildFactory {

	
	private static DefaultSmsModeBuildFactory factory = new DefaultSmsModeBuildFactory();
	
	private DefaultSmsModeBuildFactory(){
		
	}
	/**
	 * 创建阿里云验证码短信发送类
	 * @return
	 */
	public SmsSendAbstractMode createDefaultAlSsm(){
		Properties pp = SystemPropertiesUtil.getProps();
		String product =pp.getProperty("ali_sms_product");
		String domain = pp.getProperty("ali_sms_domain");
		String accessKeyId = pp.getProperty("ali_sms_accessKeyId");
		String accessKeySecret = pp.getProperty("ali_sms_accessKeySecret");
		String signName = pp.getProperty("ali_sms_vcode_signName");
		String templateCode = pp.getProperty("ali_sms_vcode_templateCode");
		DefaultAliyunSmsSendMode aliSmsMode = new DefaultAliyunSmsSendMode(product,domain,accessKeyId,accessKeySecret,signName,templateCode);
		return aliSmsMode;
	}
	
	public static DefaultSmsModeBuildFactory getInstance(){
		return factory;
	}
	
	
}
