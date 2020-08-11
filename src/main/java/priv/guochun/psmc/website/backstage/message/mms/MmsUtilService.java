package priv.guochun.psmc.website.backstage.message.mms;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Base64;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.common.log.service.TSysOperLogService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.UUIDGenerator;

public class MmsUtilService {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(MmsUtilService.class);
	
	final static String CREATE_URL = "https://vip.veesing.com/mmsApi/create";
	final static String SEND_URL = "https://vip.veesing.com/mmsApi/send";
    final static String APPID = "79M784I9SQMH";
    final static String APPKEY = "YFUC24KWKBX5CTRC";
    
  
    private TSysOperLogService tSysOperLogService;
    
    public void LogOperTask (){
        Object obj = MySpringApplicationContext.getObject("tSysOperLogService");
        if(obj !=null)
            this.tSysOperLogService = (TSysOperLogService)obj;
        else
            logger.warn("bean id tSysOperLogService not in spring context");
    }
    
    public String create(String mmsContent,String mmsPath) {
    	LogOperTask ();
    	TSysOperLog tSysOperLog = new TSysOperLog();
    	tSysOperLog.setUuid(UUIDGenerator.createUUID());
    	tSysOperLog.setLogSubTypeName("创建彩信接口日志");
    	tSysOperLog.setLogSubType(new BigDecimal("3.10"));
    	tSysOperLog.setLogTypeName("接口交互");
    	tSysOperLog.setLogType(new BigDecimal("3.0"));
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(CREATE_URL);
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            post.setRequestHeader("Connection", "close");
            NameValuePair[] data = { 
                    new NameValuePair("appId", APPID), 
                    new NameValuePair("appKey", APPKEY),
                    new NameValuePair("title", "四季花城助力健康生活"), 
                    new NameValuePair("content", content(mmsContent,mmsPath)) 
                    };
            post.setRequestBody(data);
            client.executeMethod(post);
            String result = new String(post.getResponseBodyAsString().getBytes());
            //System.out.println(result);
            logger.info("创建彩信接口返回result:"+result);
            tSysOperLog.setOperOutput(result);
            tSysOperLog.setOperResultDesc("系统创建彩信日志记录!");
            
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.get("returnStatus").equals("1")) {
            	tSysOperLog.setOperResult(new Short(jsonObject.get("returnStatus").toString()));
            	tSysOperLogService.save(tSysOperLog);
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
        StringBuffer sb = new StringBuffer();
        // --------文件-----
        sb.append(3);
        //获取文件
        sb.append(",jpg|" + encodeFile(mmsPath));
        // --------文字-----
        sb.append(",txt|" + encodeTxt(mmsContent));
        sb.append(";");
        System.out.println("彩信报文："+sb.substring(0, sb.length() - 1));
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
    
    public void send(String mmsId,String phone) {
    	TSysOperLog tSysOperLog = new TSysOperLog();
    	tSysOperLog.setUuid(UUIDGenerator.createUUID());
    	tSysOperLog.setLogSubTypeName("发送彩信接口日志");
    	tSysOperLog.setLogSubType(new BigDecimal("3.10"));
    	tSysOperLog.setLogTypeName("接口交互");
    	tSysOperLog.setLogType(new BigDecimal("3.0"));
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(SEND_URL);
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            post.setRequestHeader("Connection", "close");
            NameValuePair[] data = { 
                    new NameValuePair("appId", APPID), 
                    new NameValuePair("appKey", APPKEY),
                    new NameValuePair("mmsId", mmsId),
                    // new NameValuePair("sendTime", "2020-11-07 14:37:31"),
                    new NameValuePair("phone", phone) };
            post.setRequestBody(data);
            client.executeMethod(post);
            String result = new String(post.getResponseBodyAsString().getBytes());
            tSysOperLog.setOperOutput(result);
            tSysOperLog.setOperResultDesc("系统发送彩信日志记录!");
            tSysOperLogService.save(tSysOperLog);
            logger.info("彩信发送回执："+result);
            //System.out.println(result);
            post.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * 短信发送
	 * @return
	 */
	public void smsSend(String phone,String content) {
		LogOperTask ();
		TSysOperLog tSysOperLog = new TSysOperLog();
    	tSysOperLog.setUuid(UUIDGenerator.createUUID());
    	tSysOperLog.setLogSubTypeName("发送短信接口日志");
    	tSysOperLog.setLogSubType(new BigDecimal("3.10"));
    	tSysOperLog.setLogTypeName("接口交互");
    	tSysOperLog.setLogType(new BigDecimal("3.0"));
		// 将要群发的手机号码，手机号码之间请用英文逗号隔开
        //String phone = "";
		// 获取连接
        HttpClient client = new HttpClient();
        // 短信群发API接口地址
        PostMethod method = new PostMethod("https://vip.veesing.com/smsApi/group");
        // 设置编码
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=utf-8");
        
        // 发送内容
       // String content = "【中昱维信】您的短信群发功能已开通，请在3个工作日之内至平台进行企业认证！";
        // 拼接参数
        NameValuePair[] data = { 
                new NameValuePair("appId", APPID), 
                new NameValuePair("appKey", APPKEY),
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
            tSysOperLog.setOperOutput(result);
            tSysOperLog.setOperResultDesc("系统发送短信日志记录!");
            JSONObject jsonObject = JSONObject.parseObject(result);
            // 返回1则发送成功(逻辑操作请根据接口文档返回参数自行判断)
            if (jsonObject.get("returnStatus").equals("1")) {
            	tSysOperLog.setOperResult(new Short(jsonObject.get("returnStatus").toString()));
            	tSysOperLogService.save(tSysOperLog);
                logger.info("发送成功");
            } else {
                logger.info("发送失败");
            }
            // 释放连接
            method.setRequestHeader("Connection", "close");  
            method.releaseConnection();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public TSysOperLogService gettSysOperLogService() {
		return tSysOperLogService;
	}

	public void settSysOperLogService(TSysOperLogService tSysOperLogService) {
		this.tSysOperLogService = tSysOperLogService;
	}
}
