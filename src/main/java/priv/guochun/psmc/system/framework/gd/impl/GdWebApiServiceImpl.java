package priv.guochun.psmc.system.framework.gd.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.Cache;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.gd.GdWebApiService;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

import java.util.HashMap;
import java.util.Map;


public class GdWebApiServiceImpl implements GdWebApiService {

    /**
     * 高德步行2.0规划服务
     * @param param
     * @return
     */
    public MsgModel walking(Map<String,Object> param){
        MsgModel mm;
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String url =map.get("gdmap_walking_webapi_url").toString();
        JSONObject gdmap_key =JSONObject.parseObject(map.get("gdmap_key").toString());
        param.put("key", gdmap_key.getString("webapi"));
        String result = HttpConnectUtil.get(url,  param);
        JSONObject resultObj = (JSONObject)JSONObject.parse(result);
        if (resultObj != null && resultObj.getIntValue("status") == 1) {
             mm = MsgModel.buildDefaultSuccess(resultObj);
        }else{
             mm = MsgModel.buildDefaultError(resultObj.getString("info"));
        }
        return mm;
    }
}
