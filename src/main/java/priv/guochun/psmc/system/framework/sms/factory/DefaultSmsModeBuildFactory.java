package priv.guochun.psmc.system.framework.sms.factory;

import java.util.Properties;

import priv.guochun.psmc.system.framework.sms.core.SmsSendAbstractMode;
import priv.guochun.psmc.system.framework.sms.core.impl.ChuangxinSmsSendMode;
import priv.guochun.psmc.system.framework.sms.core.impl.DefaultAliyunSmsSendMode;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.message.mms.MmsUtilSendMode;

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
	
	
    public SmsSendAbstractMode createChuangXinSsm(){
        if(chuangxinSmsMode == null){
            Properties pp = SystemPropertiesUtil.getProps();
            String chuangx_url =pp.getProperty("chuangx_url");
            String chuangx_userid = pp.getProperty("chuangx_userid");
            String chuangx_account = pp.getProperty("chuangx_account");
            String chuangx_password = pp.getProperty("chuangx_password");
            chuangxinSmsMode = new ChuangxinSmsSendMode(chuangx_url,chuangx_userid,chuangx_account,chuangx_password);
        }
        return chuangxinSmsMode;
    }
    public SmsSendAbstractMode createZhongYiSsm(){
        if(mmsUtilSendMode == null){
            Properties pp = SystemPropertiesUtil.getProps();
            String zhongyi_sms_create_url =pp.getProperty("create_url");
            String zhongyi_sms_send_url = pp.getProperty("sms_send_url");
            String zhongyi_ssm_send_url = pp.getProperty("send_url");
            String zhongyi_sms_custom_url = pp.getProperty("custom_url");
            String zhongyi_appid = pp.getProperty("appid");
            String zhongyi_appkey = pp.getProperty("appkey");
            mmsUtilSendMode = new MmsUtilSendMode(zhongyi_sms_create_url, zhongyi_sms_send_url, zhongyi_ssm_send_url,zhongyi_sms_custom_url, zhongyi_appid, zhongyi_appkey);
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
