package priv.guochun.psmc.system.framework.sms.factory;

import org.springframework.cache.Cache;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.sms.core.SmsSendAbstractMode;
import priv.guochun.psmc.system.framework.sms.core.impl.ChuangxinSmsSendMode;
import priv.guochun.psmc.system.framework.sms.core.impl.DefaultAliyunSmsSendMode;
import priv.guochun.psmc.system.framework.sms.core.impl.MmsUtilSendMode;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;


import java.util.Map;

public class DefaultSmsModeBuildFactory {

	
	private static DefaultSmsModeBuildFactory factory = new DefaultSmsModeBuildFactory();
	
	private ChuangxinSmsSendMode chuangxinSmsMode = null;
	
	private MmsUtilSendMode mmsUtilSendMode=null;
	
	private DefaultSmsModeBuildFactory(){
		
	}
	/**
	 * 创建阿里云验证码短信发送类
	 * @return
	 */
	public SmsSendAbstractMode createDefaultAlSsm(){
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String product =map.get("ali_sms_product").toString();
		String domain = map.get("ali_sms_domain").toString();
		String accessKeyId = map.get("ali_sms_accessKeyId").toString();
		String accessKeySecret = map.get("ali_sms_accessKeySecret").toString();
		String signName = map.get("ali_sms_vcode_signName").toString();
		String templateCode = map.get("ali_sms_vcode_templateCode").toString();
		DefaultAliyunSmsSendMode aliSmsMode = new DefaultAliyunSmsSendMode(product,domain,accessKeyId,accessKeySecret,signName,templateCode);
		return aliSmsMode;
	}
	
	
    public SmsSendAbstractMode createChuangXinSsm(){
        if(chuangxinSmsMode == null){
            PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
            Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
            Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
            String chuangx_url =map.get("chuangx_url").toString();
            String chuangx_userid = map.get("chuangx_userid").toString();
            String chuangx_account = map.get("chuangx_account").toString();
            String chuangx_password =map.get("chuangx_password").toString();
            chuangxinSmsMode = new ChuangxinSmsSendMode(chuangx_url,chuangx_userid,chuangx_account,chuangx_password);
        }
        return chuangxinSmsMode;
    }
    public SmsSendAbstractMode createZhongYiSsm(){
        if(mmsUtilSendMode == null){
            PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
            Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
            Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
            String zhongyi_sms_create_url =map.get("zhongyi_create_url").toString();
            String zhongyi_sms_send_url = map.get("zhongyi_sms_send_url").toString();
            String zhongyi_mms_send_url = map.get("zhongyi_mms_send_url").toString();
            String zhongyi_sms_custom_url = map.get("zhongyi_sms_custom_url").toString();
            String zhongyi_mms_balance_url = map.get("zhongyi_mms_balance_url").toString();
    		String zhongyi_sms_balance_url = map.get("zhongyi_sms_balance_url").toString();
    		String zhongyi_sms_custom_balance_url = map.get("zhongyi_sms_custom_balance_url").toString();
            String zhongyi_appid = map.get("zhongyi_appid").toString();
            String zhongyi_appkey = map.get("zhongyi_appkey").toString();
            mmsUtilSendMode = new MmsUtilSendMode(zhongyi_sms_create_url, zhongyi_sms_send_url, zhongyi_mms_send_url,zhongyi_sms_custom_url,zhongyi_mms_balance_url, zhongyi_sms_balance_url,zhongyi_sms_custom_balance_url,zhongyi_appid, zhongyi_appkey);
        }
        return mmsUtilSendMode;
    }
    public static void main(String[] args){
        //DefaultSmsModeBuildFactory.getInstance().
        //createChuangXinSsm().sendSms("18392101807", "【四季花城】尊敬的XX，您2019/02/16的消费项目为XXXX，剩余XX次，剩余积分7820分。为提升品牌服务，诚邀您参与满意度测评，点击http://agsl.biz/Fcd7ML 可对本次体验作出评价，期待您的宝贵建议！");
    }
	
	public static DefaultSmsModeBuildFactory getInstance(){
		return factory;
	}
	
	
}
