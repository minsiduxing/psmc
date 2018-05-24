package priv.guochun.psmc.system.framework.util;

import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


public class GsonUtil
{
   
    /**
     * <p>Description: 将普通对象转换为JSON对象<p>
     * @param object 对象
     * @return JSON对象
     * @author hanlin 2014-8-26
     */
    public static String toJsonForObject(Object object)
    {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new SQLDateTypeAdapter())
                .registerTypeHierarchyAdapter(Timestamp.class, new TimestampTypeAdapter()).serializeNulls().create();
        String jsonStr = gson.toJson(object);
        return jsonStr;
    }
    /**
     * <p>Description: 将JSON字符串转成出入的对象<p>
     * @param cls 类
     * @param json JSON字符串
     * @return 类对象
     * @author liyuanchao 2017-11-8
     * @return 
     */
    public static <T> T fromJSON(Class<T> cls, String json)
    {
        // new Gson().fromJson(applyMaterialArray, WSApplyMaterialModel[].class);
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new SQLDateTypeAdapter())
                .registerTypeHierarchyAdapter(Timestamp.class, new TimestampTypeAdapter()).create();
        return gson.fromJson(json, cls);
    }

}

class TimestampTypeAdapter implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp>
{
    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public JsonElement serialize(Timestamp time, Type type, JsonSerializationContext context)
    {
        String dateFormatAsString = format.format(new Date(time.getTime()));
        return new JsonPrimitive(dateFormatAsString);
    }

    @Override
    public Timestamp deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException
    {
        return new Timestamp(Date.valueOf(json.getAsString()).getTime());
    }
}

class SQLDateTypeAdapter implements JsonSerializer<Date>
{
    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext context)
    {
        String dateFormatAsString = format.format(new Date(date.getTime()));
        return new JsonPrimitive(dateFormatAsString);
    }
}
