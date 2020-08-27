package priv.guochun.psmc.system.framework.sms.core.impl;

import java.util.HashMap;
import java.util.Map;

import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.core.SmsSendAbstractMode;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 阿里云验证码短信发送类
 * @author guochun
 *
 */

public class DefaultAliyunSmsSendMode extends SmsSendAbstractMode
{
	private String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	private String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	
	private String accessKeyId = "LTAIpW6AHbK6GmwQ";//你的accessKeyId,参考本文档步骤2
	private String accessKeySecret = "jq9FnqoALSDpLnCjM7AkCKyH34a0WT";//你的accessKeySecret，参考本文档步骤2
	
	private String signName;
	private String templateCode;
	
	
	public DefaultAliyunSmsSendMode(String product,String domain,
			String accessKeyId,String accessKeySecret,
			String signName,String templateCode){
		this.product = product;
		this.domain = domain;
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.signName = signName;
		this.templateCode = templateCode;
	}

	@Override
	public MsgModel sendSms(SmsModel msgModel) {
		String mobile=msgModel.getReceiveNo(); 
    	String content = msgModel.getReceiveContext();
		return reallySend(mobile,content);
	}
	
	public MsgModel reallySend(String mobile, String content){
		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		 //初始化ascClient,暂时不支持多region（请勿修改）
		 IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
		 try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			e1.printStackTrace();
			 return MsgModel.buildDefaultError("DefaultProfile.addEndpoint error :"+e1.getMessage());
		}
		 IAcsClient acsClient = new DefaultAcsClient(profile);
		 //组装请求对象
		 SendSmsRequest request = new SendSmsRequest();
		 //使用post提交
		 request.setMethod(MethodType.POST);
		 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
		 request.setPhoneNumbers(mobile);
		 //必填:短信签名-可在短信控制台中找到
		 request.setSignName(signName);
		 //必填:短信模板-可在短信控制台中找到
		 request.setTemplateCode(templateCode);
		 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		 request.setTemplateParam(content);
		 //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		 //request.setSmsUpExtendCode("90997");
		 //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		 request.setOutId("psmc");
		//请求失败这里会抛ClientException异常
		 SendSmsResponse sendSmsResponse = null;
		 try{
			  sendSmsResponse = acsClient.getAcsResponse(request);
		 }catch(Exception e){
			 e.printStackTrace();
			 return MsgModel.buildDefaultError(e.getMessage());
		 }
		
		 if(sendSmsResponse != null && sendSmsResponse.getCode().equals("OK")) {
			 //请求成功
			 return MsgModel.buildDefaultSuccess(null);
		 }else{
			 //请求失败
			 return MsgModel.buildDefaultError(sendSmsResponse.getCode());
		 }
	}

	@Override
	public String getBalance(String sendType) {
		// TODO Auto-generated method stub
		return null;
	}
}
