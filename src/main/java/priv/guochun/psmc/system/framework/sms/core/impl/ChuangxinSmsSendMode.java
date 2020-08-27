package priv.guochun.psmc.system.framework.sms.core.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import priv.guochun.psmc.system.common.city.controller.CityController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.sms.core.SmsSendAbstractMode;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;

/**
 * 
 * <p>Title: 创信java短信接口</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2019</p>
 * @author <a href="mailTo:guochun002@chinasofti.com">guochun002</a>
 * @version 1.0
 * @history:
 * Created by guochun002 2019-4-26
 */

public class ChuangxinSmsSendMode extends SmsSendAbstractMode
{
    
    protected static final  Logger logger  = LoggerFactory.getLogger(CityController.class);
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
    private  String url = "";
    private  String userid = "";
    private  String account = "";
    private  String password = "";
    
    public ChuangxinSmsSendMode(String url,String userid,String account,String password){
        this.url = url;
        this.userid = userid;
        this.account = account;
        this.password = password;
    }
    
    
    @Override
    public MsgModel sendSms(SmsModel msgModel)
    {
    	String mobile=msgModel.getReceiveNo(); 
    	String content = msgModel.getReceiveContext();
        String dateStr = sf.format(new Date());
        String str = account + password + dateStr;//MD5加密，账号+密码+时间戳
        String sign = MD5(str);
        try{
            return reallySend(mobile,content,sign,dateStr);
        }
        catch (Exception e){
            e.printStackTrace();
            return MsgModel.buildDefaultError(e.getMessage());
        }
    }
    
    //MD5加密,账号+密码+时间戳
     public static String MD5(String str) {
         try {
                MessageDigest digest =MessageDigest.getInstance("MD5");
                byte[] bs = digest.digest(str.getBytes("utf-8"));            
                StringBuffer zm =new StringBuffer();
                for (byte b : bs) {
                    int i=b&0xff; 
                    String hexString = Integer.toHexString(i);
                    if (hexString.length()<2) {
                        hexString="0"+hexString;
                    }
                    zm.append(hexString);
                    }
                    return zm.toString();
                    } 
                    catch (Exception e) {
                    return null;
              }
        }
    

    // 发送短信
    public MsgModel reallySend(String mobile, String content,String sign,String dateStr) throws IOException {
        
        String requestUrl = url + "?action=send&rt=json&userid=" + userid
                + "&timestamp=" + dateStr
                + "&sign=" + sign
                + "&mobile=" + mobile 
                + "&content=" + URLEncoder.encode(content, "utf-8") 
                + "&sendTime=&extno=";
        URL getUrl = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) getUrl
                .openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),"UTF-8"));
        String lines="";
        String line;
        while ((line = reader.readLine()) != null) {
            lines += line;
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        logger.info("短信接口调用完成，接口返回信息如下"+lines);
        if(StringUtils.isEmpty(lines)){
            return MsgModel.buildDefaultError("短信接口调用失败,返回信息为空!");
        }else{
            JSONObject jo = JSON.parseObject(lines);
            String ReturnStatus = jo.get("ReturnStatus")!=null?jo.get("ReturnStatus").toString():"";
            String Message = jo.get("Message")!=null?jo.get("Message").toString():"";
            String RemainPoint = jo.get("RemainPoint")!=null?jo.get("RemainPoint").toString():"";
            String SuccessCounts = jo.get("SuccessCounts")!=null?jo.get("SuccessCounts").toString():"";
            
            if(!"Success".equals(ReturnStatus)){
                return MsgModel.buildDefaultError("短信接口调用失败 "+jo.toJSONString());
            }else{
                return MsgModel.buildDefaultSuccess("短信接口调用成功 "+jo.toJSONString());
            }
        }
    }

//    // 上行，获取短信回复
//    public static String Mo(String dateStr,String sign)
//            throws IOException {
//
//        String requestUrl = GET_URL + "/v2callApi.aspx?action=query&rt=json&userid=" + userid
//                + "&timestamp=" + dateStr
//                + "&sign=" + sign;
//
//        URL getUrl = new URL(requestUrl);
//
//        HttpURLConnection connection = (HttpURLConnection) getUrl
//                .openConnection();
//
//        connection.connect();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                connection.getInputStream(),"UTF-8"));
//        
//        String lines;
//
//        while ((lines = reader.readLine()) != null) {
//
//            lines += lines;
//
//        }
//
//        reader.close();
//
//        connection.disconnect();
//
//        return lines;
//
//    }
//
//    // 查询余额
//    public static String Balance(String dateStr,String sign)
//            throws IOException {
//
//        String requestUrl = GET_URL + "/v2sms.aspx?action=overage&rt=json&userid="+ userid 
//                + "&timestamp=" + dateStr
//                + "&sign=" + sign;
//
//        URL getUrl = new URL(requestUrl);
//
//        HttpURLConnection connection = (HttpURLConnection) getUrl
//                .openConnection();
//
//        connection.connect();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                connection.getInputStream(),"UTF-8"));
//
//        String lines;
//
//        while ((lines = reader.readLine()) != null) {
//
//            lines += lines;
//
//        }
//
//        reader.close();
//
//        connection.disconnect();
//
//        return lines;
//
//    }


    public static void main(String[] args){
        //ChuangxinSmsSendMode mode = new ChuangxinSmsSendMode("http://dc.28inter.com/v2sms.aspx/v2sms.aspx","1706","sjhc1","sjhc1@123456");
        //mode.sendSms("18392101807", "【四季花城】尊敬的郭纯，您2019/05/09的消费金额为1350元，剩余金额1234元，剩余积分7820分。为提升品牌服务，诚邀您参与满意度测评，点击http://agsl.biz/Fcd7ML 可对本次体验作出评价，期待您的宝贵建议！");
    }


	@Override
	public String getBalance(String sendType) {
		// TODO Auto-generated method stub
		return null;
	}
}
