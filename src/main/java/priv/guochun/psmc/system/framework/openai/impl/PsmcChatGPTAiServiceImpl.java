package priv.guochun.psmc.system.framework.openai.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.Cache;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.openai.PsmcAiService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class PsmcChatGPTAiServiceImpl implements PsmcAiService {

    public MsgModel testAiService(){
        MsgModel mm = null;
        Map<String, String> header = new HashMap<String, String>();
        header.put("AUthorization","Bearer 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");
        header.put("Content-Type","application/json; charset=UTF-8");
        String url ="https://api.openai.com/v1/completions";
        PsmcChatGPTAiServiceImpl gpt = new PsmcChatGPTAiServiceImpl();
        JSONObject data = new JSONObject();
        data.put("model","text-davinci-003");
        data.put("prompt","张艺谋的电影作品你了解多少呢");
        data.put("n",1);
        data.put("max_tokens",2048);
        data.put("top_p",1); //，0.1意味着只考虑包含最高10%概率质量的内容
        data.put("temperature",0);
        try{
            String result = HttpConnectUtil.postJson(url,data.toJSONString(),header);
            JSONObject resultObj = (JSONObject)JSONObject.parse(result);
            JSONArray ja = resultObj.get("choices")!=null? JSONArray.parseArray(resultObj.get("choices").toString()):null;
            JSONObject obj = ja.getJSONObject(0);
            if(obj!=null && obj.get("text") !=null){
                mm = MsgModel.buildDefaultSuccess(ja.getJSONObject(0).get("text").toString());
            }
        }catch(Exception e){
            mm = MsgModel.buildDefaultError("chatGPT服务异常,您可以继续尝试询问!");
        }
        return mm;
    }


    public MsgModel completions(JSONObject data){
        MsgModel mm = MsgModel.buildDefaultSuccess();
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);

        Map<String, String> header = new HashMap<String, String>();
        header.put("AUthorization",map.get("openai_key").toString());
        header.put("Content-Type","application/json; charset=UTF-8");
        String url =map.get("openai_completions_url").toString();
        try{
            String result = HttpConnectUtil.postJson(url,data.toJSONString(),header);
            JSONObject resultObj = (JSONObject)JSONObject.parse(result);
            JSONArray ja = resultObj.get("choices")!=null? JSONArray.parseArray(resultObj.get("choices").toString()):null;
            JSONObject obj = ja.getJSONObject(0);
            if(obj!=null && obj.get("text") !=null){
                mm = MsgModel.buildDefaultSuccess(ja.getJSONObject(0).get("text").toString());
            }
        }catch(Exception e){
            mm = MsgModel.buildDefaultError("chatGPT服务异常,您可以继续尝试询问!");
        }
        return mm;
    }

    public MsgModel createImage(JSONObject data){
        MsgModel mm = MsgModel.buildDefaultSuccess();
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);

        Map<String, String> header = new HashMap<String, String>();
        header.put("AUthorization",map.get("openai_key").toString());
        header.put("Content-Type","application/json; charset=UTF-8");
        String url =map.get("openai_images_generations_url").toString();
        try{
            String result = HttpConnectUtil.postJson(url,  data.toJSONString(),header);
            JSONObject resultObj = (JSONObject)JSONObject.parse(result);
            JSONArray ja = resultObj.get("data")!=null? JSONArray.parseArray(resultObj.get("data").toString()):null;
            JSONObject obj = ja.getJSONObject(0);
            if(obj!=null && obj.get("url") !=null){
                mm = MsgModel.buildDefaultSuccess(ja.getJSONObject(0).get("url").toString());
            }
        }catch(Exception e){
            mm = MsgModel.buildDefaultError("chatGPT服务异常,您可以继续尝试询问!");
        }
        return mm;
    }

    public static void main(String[] args){
        PsmcChatGPTAiServiceImpl gpt = new PsmcChatGPTAiServiceImpl();
        JSONObject data = new JSONObject();
        data.put("model","text-davinci-003");
        data.put("prompt","张艺谋的电影作品你了解多少呢");
        data.put("n",1);
        data.put("max_tokens",2048);
        data.put("top_p",1); //，0.1意味着只考虑包含最高10%概率质量的内容
//        data.put("stream",Boolean.TRUE);
        data.put("temperature",0);
        System.out.println("返回结果 :"+gpt.testAiService().getData().toString());
    }
}
