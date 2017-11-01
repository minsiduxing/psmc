package priv.guochun.psmc.system.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import priv.guochun.psmc.system.framework.page.MyPage;

public class JsonUtil {

	/**
	 * 将一个包含map的list 包装成一个jsonObject返回,
	 * jsonObject是一个key为listArray,value为json数组的对象
	 * @param list
	 * @return {"listArray" :[{mapkey:mapvalue},{mapkey:mapvalue}]}
	 */
	
	public static JSONObject convertToJSONObject( List<Map<?,?>> list ){
		if(list == null || list.size()<=0)
			return null;
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<list.size();i++){
    		Map map =  list.get(i);
    		JSONObject jo = new JSONObject();
    		Iterator iter = map.keySet().iterator();
    		while(iter.hasNext()){
    			String key = iter.next().toString();
    			String value = map.get(key)!=null?map.get(key).toString():"";
    			jo.put(key, value);
    		}
    		jsonArray.put(jo);
    	}
		JSONObject returnObj = new JSONObject();
		returnObj.put("listArray", jsonArray);
		return returnObj;
	}
	
	/**
	 * 将一个包含map的list 包装成一个JSONArray返回
	 * @param list
	 * @return
	 */
	public static JSONArray convertToJSONArray( List<Map<?,?>> list ){
	    JSONArray jsonArray = new JSONArray();
		if(list == null || list.size()<=0)
			return jsonArray;
		
		for(int i=0;i<list.size();i++){
    		Map map =  list.get(i);
    		JSONObject jo = new JSONObject();
    		Iterator iter = map.keySet().iterator();
    		while(iter.hasNext()){
    			String key = iter.next().toString();
    			String value = map.get(key)!=null?map.get(key).toString():"";
    			jo.put(key, value);
    		}
    		jsonArray.put(jo);
    	}
		return jsonArray;
	}
	
	/**
	 * 将一个map 转换成JSONObject返回
	 * @param map
	 * @return 
	 */
	public static JSONObject convertToJSONObject( Map<?,?> map ){
		if(map == null)
			return null;
		JSONObject jo = new JSONObject();
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()){
    		String key =  iter.next().toString();
    		String value = map.get(key)!=null?map.get(key).toString():"";
    		jo.put(key, value);
    	}
		return jo;
	}
	
	/**
	 * 将一个自定义的分页信息实例MyPage，包装成一个前台esay ui可识别的jsonObject并返回
	 * @param mypage
	 * @return {"total":"数据总数","rows" :"JSONArray数组"}
	 */

	public static JSONObject convertToJSONObject(MyPage mypage ){
		if(mypage == null)
			return null;
		JSONObject jo = new JSONObject();
		jo.put("total", mypage.getTotalData());
		List dataList = mypage.getDataList();
		JSONArray ja = convertToJSONArray(dataList);
		jo.put("rows", ja);
		return jo;
	}

  

}
