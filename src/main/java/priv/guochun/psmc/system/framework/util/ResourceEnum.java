package priv.guochun.psmc.system.framework.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

import priv.guochun.psmc.system.util.JsonUtil;

public enum ResourceEnum
{
    ResourceType1("系统",1,null),
    ResourceType2("导航模块",2,null),
    ResourceType3("菜单",3,null),
    
    PsmcRootId("系统根节点",0,"e51a8663876f4a3394bb194d89d96735");
    
    
    private String name;
    private int index;
    private String uuid;
    
    private ResourceEnum(String name, Integer index,String uuid)
    {
        this.name = name;
        this.index = index;
        this.uuid = uuid;
    }

    public static String getName(Integer index)
    {
        if(index == null) return null;
        
        for (ResourceEnum p : ResourceEnum.values())
        {
            if (p.getIndex() == index)
            {
                return p.name;
            }
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * 将该枚举类转为JSON数组
	 * <p>Description:<p>
	 * @return
	 * @author wenxiaoming 2017年7月5日
	 */
	@SuppressWarnings({"rawtypes", "unchecked" })
    public static JSONArray ResourceType(){
	    Map map = null;
	    List list = new ArrayList();
	    for(ResourceEnum r: ResourceEnum.values()){
	        if(r.index !=  0){
    	        map = new HashMap();
    	        map.put("id", r.index);
    	        map.put("text", r.name);
                list.add(map);
	        }
        }
	    JSONArray json = JsonUtil.convertToJSONArray(list);
	    return json;
	}
	
}
