package priv.guochun.psmc.website.backstage.message.mms;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.core.SmsSendAbstractMode;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

public class MmsUtilSendMode extends SmsSendAbstractMode{
	
	protected static final  Logger logger  = LoggerFactory.getLogger(MmsUtilSendMode.class);
	
	private  String zhongyi_sms_create_url = "";
    private  String zhongyi_sms_send_url = "";
    private  String zhongyi_ssm_send_url = "";
    private  String zhongyi_sms_custom_url ="";
    private  String zhongyi_mms_balance_url = "";
    private  String zhongyi_sms_group_url = "";
    private  String zhongyi_sms_custom_balance_url ="";
    private  String zhongyi_appid = "";
    private  String zhongyi_appkey = "";
    
    
    public MmsUtilSendMode(String zhongyi_sms_create_url, String zhongyi_sms_send_url, String zhongyi_ssm_send_url,String zhongyi_sms_custom_url,
    		String zhongyi_mms_balance_url, String zhongyi_sms_group_url,String zhongyi_sms_custom_balance_url,
			String zhongyi_appid, String zhongyi_appkey) {

	}

    
    public String create(String mmsContent,String mmsPath) {
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(zhongyi_sms_create_url);
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            post.setRequestHeader("Connection", "close");
            NameValuePair[] data = { 
                    new NameValuePair("appId", zhongyi_appid), 
                    new NameValuePair("appKey", zhongyi_appkey),
                    new NameValuePair("title", "四季花城助力健康生活"), 
                    new NameValuePair("content", content(mmsContent,mmsPath)) 
                    };
            post.setRequestBody(data);
            client.executeMethod(post);
            String result = new String(post.getResponseBodyAsString().getBytes());
            logger.info("创建彩信接口返回result:"+result);
            
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.get("returnStatus").equals("1")) {
                	return jsonObject.get("taskId").toString();
            } else {
            	logger.info("创建彩信接口失败");
            }
            post.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 一帧<br> 
     * 多帧循环生成
     * 
     * @return
     */
    public  String content(String mmsContent,String mmsPath) {
    	String content = mmsContent.substring(mmsContent.indexOf("|")+1, mmsContent.length());
    	String paths = mmsContent.substring(0, mmsContent.indexOf("|"));
    	String[] pathStr = paths.split(",");
        StringBuffer sb = new StringBuffer();
        for (String string : pathStr) {
	        // --------文件-----
	        sb.append(3);
	        //获取文件
        	sb.append(",jpg|" + encodeFile(string));
        	// --------文字-----
        	sb.append(",txt|" + encodeTxt(content));
        	sb.append(";");
		}
        logger.info("彩信报文："+sb.substring(0, sb.length() - 1));
        return sb.substring(0, sb.length() - 1);
    }

    public String encodeFile(String filePath) {
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(data).replaceAll("[\\t\\n\\r]", "");
    }

    public String encodeTxt(String txt) {
        try {
            return Base64.getEncoder().encodeToString(new String(txt).getBytes("gb2312"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public MsgModel send(String mmsId,String phone) {
        
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(zhongyi_sms_send_url);
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            post.setRequestHeader("Connection", "close");
            NameValuePair[] data = { 
            		new NameValuePair("appId", zhongyi_appid), 
                    new NameValuePair("appKey", zhongyi_appkey),
                    new NameValuePair("mmsId", mmsId),
                    // new NameValuePair("sendTime", "2020-11-07 14:37:31"),
                    new NameValuePair("phone", phone) };
        try {
	            post.setRequestBody(data);
	            client.executeMethod(post);
	            String result = new String(post.getResponseBodyAsString().getBytes());
	            logger.info("彩信发送回执："+result);
	            
	            if(StringUtils.isEmpty(result)){
	            	return MsgModel.buildDefaultError("短信接口调用失败,返回信息为空!");
	            }else {
		            JSONObject jsonObject = JSONObject.parseObject(result);
		            if (jsonObject.get("returnStatus").equals("1")) {
		            	return MsgModel.buildDefaultSuccess("短信接口调用成功 "+jsonObject.toJSONString());
		            } else {
		            	return MsgModel.buildDefaultError("短信接口调用失败 "+jsonObject.toJSONString());
		            }
	            }
        } catch (Exception e) {
            e.printStackTrace();
            return MsgModel.buildDefaultError("短信接口调用失败!:"+e.getMessage());
        }finally {
        	post.releaseConnection();
		}
    }
    
    /**
	 * 短信发送
	 * @return
	 */
	public MsgModel smsSend(String phone,String content) {
		// 将要群发的手机号码，手机号码之间请用英文逗号隔开
        //String phone = "";
		// 获取连接
        HttpClient client = new HttpClient();
        // 短信群发API接口地址
        PostMethod method = new PostMethod(zhongyi_ssm_send_url);
        // 设置编码
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=utf-8");
        
        // 发送内容
       // String content = "【中昱维信】您的短信群发功能已开通，请在3个工作日之内至平台进行企业认证！";
        // 拼接参数
        NameValuePair[] data = { 
        		new NameValuePair("appId", zhongyi_appid), 
                new NameValuePair("appKey", zhongyi_appkey),
                new NameValuePair("phone", phone), 
                // 发送时间，时间请务必大于实际提交时间的30分钟， 立即发送则不填，
                // new NameValuePair("sendTime", "2018-08-21 14:00:00") ,
                new NameValuePair("content", content)};
        		method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String result = method.getResponseBodyAsString();
            // 返回结果
            logger.info("返回结果："+result);
            if(StringUtils.isEmpty(result)) {
            		return MsgModel.buildDefaultError("短信接口调用失败,返回信息为空!");
            }else {
		            JSONObject jsonObject = JSONObject.parseObject(result);
		            // 返回1则发送成功(逻辑操作请根据接口文档返回参数自行判断)
		            if (jsonObject.get("returnStatus").equals("1")) {
		            	return MsgModel.buildDefaultSuccess("短信接口调用成功 "+jsonObject.toJSONString());
		            } else {
		                return MsgModel.buildDefaultError("短信接口调用失败 "+jsonObject.toJSONString());
		            }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MsgModel.buildDefaultError("短信接口调用失败!:"+e.getMessage());
        }finally {
        	 // 释放连接
        	 method.setRequestHeader("Connection", "close");  
             method.releaseConnection();
		}
		
	}

	//个性化短信定制
	public MsgModel gxhSendSms(String smsId,String content) {
		// 获取连接
        HttpClient client = new HttpClient();
        // 定制短信群发API接口地址
        PostMethod method = new PostMethod(zhongyi_sms_custom_url);
        // 设置编码
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=utf-8");
        // 发送内容
        //String content = "[{"手机号码":"15831471961","姓名":"张三","工资":"10000.00"},{"手机号码":"13076523432","姓名":"李四","工资":"20000.00"}]";
        // 拼接参数
        NameValuePair[] data = { 
                new NameValuePair("appId", zhongyi_appid), 
                new NameValuePair("appKey", zhongyi_appkey),
                new NameValuePair("smsId", smsId), 
                // 发送时间，时间请务必大于实际提交时间的30分钟， 立即发送则不填，
                // new NameValuePair("sendTime", "2018-08-21 14:00:00") ,
                new NameValuePair("content", content)};
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String result = method.getResponseBodyAsString();
            // 返回结果
            if(StringUtils.isEmpty(result)) {
        			return MsgModel.buildDefaultError("短信接口调用失败,返回信息为空!");
	        }else {
		            JSONObject jsonObject = JSONObject.parseObject(result);
		            // 返回1则发送成功(逻辑操作请根据接口文档返回参数自行判断)
		            if (jsonObject.get("returnStatus").equals("1")) {
		                return MsgModel.buildDefaultSuccess("短信接口调用成功 "+jsonObject.toJSONString());
		            } else {
		            	return MsgModel.buildDefaultError("短信接口调用失败 "+jsonObject.toJSONString());
		            }
	        }
        } catch (Exception e) {
            e.printStackTrace();
            return MsgModel.buildDefaultError("短信接口调用失败!:"+e.getMessage());
        }finally {
        	 // 释放连接
            method.setRequestHeader("Connection", "close");  
            method.releaseConnection();
		}
    }
	
	@Override
	public MsgModel sendSms(SmsModel smsModel) {
		String mobile = smsModel.getReceiveNo();
		String content = smsModel.getReceiveContext();
		String path = smsModel.getmPath();
		String smsId = smsModel.getSmsId();
		switch(smsModel.getSendType()){
			case "0":
				//短信发送
				return smsSend(mobile, content);
			case "1":
				//彩信发送
				return sendMms(mobile, content,path);
			case "2":
				//个性化短信发送
				return gxhSendSms(smsId, content);
		}
		return null;
	}


	public MsgModel sendMms(String mobile, String content, String path) {
		String taskId = create(content, path);
		if(StringUtils.isEmpty(taskId)) {
			return MsgModel.buildDefaultError("创建彩信接口返回空!");
		}else {
			return send(taskId, mobile);
		}
	}


	//短信余额查询
	public String smsBalance(String url){
		HttpClient client = new HttpClient();
		
		GetMethod get = new GetMethod(url+"appId="+zhongyi_appid+"&appKey="+zhongyi_appkey);
		try {
			client.executeMethod(get);
			String result = new String(get.getResponseBodyAsString().getBytes());
			JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.get("returnStatus").equals("1")) {
                	return jsonObject.get("remainpoint").toString();
            } else {
            	logger.info("短信余额接口返回result:"+result);
            }
            get.releaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	
	@Override
	public String getBalance(String sendType) {
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory)MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
    	this.zhongyi_sms_create_url = map.get("create_url");
		this.zhongyi_sms_send_url = map.get("send_mms_url");
		this.zhongyi_ssm_send_url = map.get("send_group_url");
		this.zhongyi_sms_custom_url = map.get("custom_url");
		this.zhongyi_mms_balance_url = map.get("mms_balance_url");
		this.zhongyi_sms_group_url = map.get("sms_group_url");
		this.zhongyi_sms_custom_balance_url = map.get("sms_custom_url");
		this.zhongyi_appid = map.get("appid");
		this.zhongyi_appkey = map.get("appkey");
		switch(sendType){
			case "0":
				//短信
				return smsBalance(zhongyi_sms_group_url);
			case "1":
				//彩信
				return smsBalance(zhongyi_mms_balance_url);
			case "2":
				//个性化短信
				return smsBalance(zhongyi_sms_custom_balance_url);
		}
		return null;
	}
	
}
