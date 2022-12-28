package priv.guochun.psmc.system.util;
import org.apache.commons.jexl3.*;

import java.util.Iterator;
import java.util.Map;

public class JetlUtil {

    public Object execute(String resultKey,String expression, Map<String,String> params){
        JexlContext jexlContext = null;
        try{
            JexlBuilder jexlBuilder = new JexlBuilder();
            // 创建Jexl表达式引擎
            JexlEngine jexlEngine = jexlBuilder.create();
            // 创建Jexl表达式解析器
            JexlScript jexlScript = jexlEngine.createScript("result=distance>=30");
            // 创建Jexl表达式变量上下文
            jexlContext = new MapContext();
            if(params !=null ){
                Iterator iter = params.keySet().iterator();
                while(iter.hasNext()){
                    String key = iter.next().toString();
                    jexlContext.set(key, params.get(key).toString());
                }
            }
            // 执行Jexl表达式，得到结果
            jexlScript.execute(jexlContext);
        }catch(Exception e){
            e.printStackTrace();
        }
        return jexlContext != null ? jexlContext.get(resultKey) : null;
    }

    public boolean execute(String expression, Map<String,String> params) {
        Object reuslt = execute("result", expression, params);
        return reuslt != null ?(Boolean)reuslt:false;
    }

}