package priv.guochun.psmc.system.framework.openai.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.cache.Cache;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.openai.PsmcAiService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PsmcChatGPTAiServiceImpl implements PsmcAiService {

    public MsgModel testAiService(JSONObject data){
        OpenAiService service = new OpenAiService("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");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(data.get("prompt").toString())
                .model(data.get("model").toString())
                .temperature(Double.parseDouble(data.get("temperature").toString()))
                .n(Integer.parseInt(data.get("n").toString()))
                .topP(Double.parseDouble(data.get("top_p").toString()))
                .maxTokens(Integer.parseInt(data.get("max_tokens").toString()))
                .echo(true)
                .build();
        return MsgModel.buildDefaultSuccess(service.createCompletion(completionRequest).getChoices().get(0).getText());
    }


    public MsgModel completions(JSONObject data){
        try{
            OpenAiService service = new OpenAiService("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");
            CompletionRequest completionRequest = CompletionRequest.builder()
                    .prompt(data.get("prompt").toString())
                    .model(data.get("model").toString())
                    .temperature(Double.parseDouble(data.get("temperature").toString()))
                    .n(Integer.parseInt(data.get("n").toString()))
                    .topP(Double.parseDouble(data.get("top_p").toString()))
                    .maxTokens(Integer.parseInt(data.get("max_tokens").toString()))
                    .echo(true)
                    .build();
            List<CompletionChoice> ccs =  service.createCompletion(completionRequest).getChoices();
            return MsgModel.buildDefaultSuccess(ccs.get(0).getText());
        }catch(Exception e){
            return MsgModel.buildDefaultError("ChatGPT服务异常:"+e.getMessage());
        }



//        MsgModel mm = MsgModel.buildDefaultSuccess();
//        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
//        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
//        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
//
//        Map<String, String> header = new HashMap<String, String>();
//        header.put("AUthorization",map.get("openai_key").toString());
//        header.put("Content-Type","application/json; charset=UTF-8");
//        String url =map.get("openai_completions_url").toString();
//        try{
//            String result = HttpConnectUtil.postJson(url,data.toJSONString(),header);
//            JSONObject resultObj = (JSONObject)JSONObject.parse(result);
//            JSONArray ja = resultObj!=null && resultObj.get("choices")!=null? JSONArray.parseArray(resultObj.get("choices").toString()):null;
//            JSONObject obj = ja.getJSONObject(0);
//            if(obj!=null && obj.get("text") !=null){
//                mm = MsgModel.buildDefaultSuccess(ja.getJSONObject(0).get("text").toString());
//            }
//        }catch(Exception e){
//            mm = MsgModel.buildDefaultError("chatGPT服务异常,您可以继续尝试询问!"+e.getMessage());
//        }
//        return mm;
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
            JSONArray ja = resultObj!=null && resultObj.get("data")!=null? JSONArray.parseArray(resultObj.get("data").toString()):null;
            JSONObject obj = ja.getJSONObject(0);
            if(obj!=null && obj.get("url") !=null){
                mm = MsgModel.buildDefaultSuccess(ja.getJSONObject(0).get("url").toString());
            }
        }catch(Exception e){
            mm = MsgModel.buildDefaultError("chatGPT服务异常,您可以继续尝试询问!"+e.getMessage());
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
        data.put("temperature",0);
        System.out.println("返回结果 :"+gpt.testAiService(data).getData().toString());
    }
}
