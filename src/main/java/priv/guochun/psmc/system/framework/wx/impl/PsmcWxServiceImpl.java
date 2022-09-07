package priv.guochun.psmc.system.framework.wx.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.framework.wx.AccessTokenService;
import priv.guochun.psmc.system.framework.wx.PsmcWxService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class PsmcWxServiceImpl implements PsmcWxService {
    protected static final Logger logger  = LoggerFactory.getLogger(PsmcWxServiceImpl.class);
    @Autowired
    AccessTokenService accessTokenService;

    @Override
    public String getAccessToken() {
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String wx_appid =map.get("wx_appid").toString();
        String wx_secret =map.get("wx_secret").toString();
        return accessTokenService.getAccessToken(wx_appid,wx_secret);
    }

    @Override
    public MsgModel getPhoneNo(String code) {
        Map<String, String> queryMap = new HashMap<>();
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String url =map.get("wx_getuserphonenumber_url").toString()+"?access_token="+getAccessToken();
        queryMap.put("code", code);
        String result = HttpConnectUtil.postJson(url, queryMap);
        logger.info("wx_getuserphonenumber_url参数:url="+url+" 结果result="+result);
        JSONObject resultObj = (JSONObject)JSONObject.parse(result);
        if (resultObj != null && resultObj.getIntValue("errcode") == 0){
            return MsgModel.buildDefaultSuccess("手机号获取成功", resultObj.get("phone_info"));
        }
        return MsgModel.buildDefaultError("手机号获取失败");
    }

    @Override
    public String codeToSession(String js_code, String mobile) {
        return null;
    }

    private MsgModel uploadTemporaryMedia(String type,File file){
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String wx_upload_temp_material_url =map.get("wx_upload_temp_material_url").toString();


        String access_token = getAccessToken();
        wx_upload_temp_material_url += "?access_token="+access_token+"&type="+type+"&media="+file.getName();

        Map<String, LinkedHashSet<String>> fileMap = new HashMap<String, LinkedHashSet<String>>();
        LinkedHashSet set = new LinkedHashSet();
        set.add(file.getAbsolutePath());
        fileMap.put("file",set);

        JSONObject resultObj = null;
        try{
            String result = HttpConnectUtil.postFile(wx_upload_temp_material_url,null,fileMap);
            logger.info("wx_upload_temp_material_url参数:url="+wx_upload_temp_material_url+" 结果result="+result);
            resultObj = (JSONObject)JSONObject.parse(result);
            if (resultObj != null && resultObj.get("errcode") == null) {
                return MsgModel.buildDefaultSuccess(result);
            }else
                return MsgModel.buildDefaultError(resultObj.toString());
        }catch(Exception e){
            return MsgModel.buildDefaultError(e.getMessage());
        }
    }

    @Override
    public MsgModel uploadTemporaryMediaForImage(File file){
        return uploadTemporaryMedia("image",file);
    }


    @Override
    public MsgModel uploadTemporaryMediaForVoice(File file){
        return uploadTemporaryMedia("voice",file);
    }

    @Override
    public MsgModel uploadTemporaryMediaForVideo(File file){
        return uploadTemporaryMedia("video",file);
    }

    @Override
    public MsgModel uploadTemporaryMediaForThumb(File file){
        return uploadTemporaryMedia("thumb",file);
    }
    @Override
    public MsgModel getTemporaryMedia(String media_id) {
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String wx_query_temp_material_url =map.get("wx_query_temp_material_url").toString();


        String access_token = getAccessToken();
        wx_query_temp_material_url += "?access_token="+access_token+"&media_id="+media_id;

        JSONObject resultObj = null;
        try{
            String result = HttpConnectUtil.get(wx_query_temp_material_url,null);
            logger.info("wx_query_temp_material_url参数:url="+wx_query_temp_material_url+" 结果result="+result);
            resultObj = (JSONObject)JSONObject.parse(result);
            if (resultObj != null && resultObj.get("errcode") == null) {
                return MsgModel.buildDefaultSuccess(result);
            }else
                return MsgModel.buildDefaultError(resultObj.toString());
        }catch(Exception e){
            return MsgModel.buildDefaultError(e.getMessage());
        }
    }

    @Override
    public MsgModel delTemporaryMedia(String media_id) {
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String wx_query_temp_material_url =map.get("wx_query_temp_material_url").toString();


        String access_token = getAccessToken();
        wx_query_temp_material_url += "?access_token="+access_token+"&media_id="+media_id;

        JSONObject resultObj = null;
        try{
            String result = HttpConnectUtil.get(wx_query_temp_material_url,null);
            logger.info("wx_query_temp_material_url参数:url="+wx_query_temp_material_url+" 结果result="+result);
            resultObj = (JSONObject)JSONObject.parse(result);
            if (resultObj != null && resultObj.get("errcode") == null) {
                return MsgModel.buildDefaultSuccess(result);
            }else
                return MsgModel.buildDefaultError(resultObj.toString());
        }catch(Exception e){
            return MsgModel.buildDefaultError(e.getMessage());
        }
    }

    @Override
    public String uploadPersistentMedia(String type, String mediaFormData) {
        return null;
    }

    @Override
    public String delPersistentMedia(String js_code, String mobile) {
        return null;
    }


}
