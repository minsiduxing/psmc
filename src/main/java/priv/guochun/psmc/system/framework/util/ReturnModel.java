package priv.guochun.psmc.system.framework.util;

import org.json.JSONObject;

public class ReturnModel
{
    private final static String default_res_key = "res";
    private final static String default_res_success = "success";
    private final static String default_res_fail= "fail";
    
    private final static  String default_res_rmsg = "rmsg";
    
    public static JSONObject createSuccessJSONObject(){
        JSONObject jo = new JSONObject();
        jo.put(default_res_key, default_res_success);
        return jo;
    }
    
    public static JSONObject createSuccessJSONObject(String message){
        JSONObject jo = new JSONObject();
        jo.put(default_res_key, default_res_success);
        jo.put(default_res_rmsg , message);
        return jo;
    }
    
    public static JSONObject createFailJSONObject(){
        JSONObject jo = new JSONObject();
        jo.put(default_res_key, default_res_fail);
        return jo;
    }
    
    public static JSONObject createFailJSONObject(String message){
        JSONObject jo = new JSONObject();
        jo.put(default_res_key, default_res_fail);
        jo.put(default_res_rmsg , message);
        return jo;
    }
}
