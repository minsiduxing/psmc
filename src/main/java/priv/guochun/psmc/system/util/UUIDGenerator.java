package priv.guochun.psmc.system.util;

import org.apache.commons.jexl3.*;

import java.util.UUID;

public class UUIDGenerator {   
    public UUIDGenerator() {   
    }   
  
    public static String createUUID() {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        // 去掉"-"符号   
        String temp = str.replace("-", "");
        return temp;   
    }   
    //获得指定数量的UUID   
    
    public static String[] createUUIDs(int number) {   
        if (number < 1) {   
            return null;   
        }   
        String[] ss = new String[number];   
        for (int i = 0; i < number; i++) {   
            ss[i] = createUUID();   
        }
            JexlBuilder jexlBuilder = new JexlBuilder();
            // 创建Jexl表达式引擎
            JexlEngine jexlEngine = jexlBuilder.create();
            // 创建Jexl表达式解析器
            JexlScript jexlScript = jexlEngine.createScript("if(GRID_PEOPLE_COUNT<1000 || (GRID_PEOPLE_COUNT>=1000 && ACTUAL_ISSUE_CERT_TOTAL<5)){ if(GRID_PEOPLE_COUNT/200-ACTUAL_ISSUE_CERT_TOTAL>0){result=true}else{result=false} } else{ if((GRID_PEOPLE_COUNT-1000)/500-(ACTUAL_ISSUE_CERT_TOTAL-5)>0){result=true}else{result=false} }");
//        JexlScript jexlScript = jexlEngine.createScript("result=GRID_PEOPLE_COUNT/200");
        // 创建Jexl表达式变量上下文
            JexlContext jexlContext = new MapContext();
            jexlContext.set("GRID_PEOPLE_COUNT", 1999);
            jexlContext.set("ACTUAL_ISSUE_CERT_TOTAL", 5);
            // 执行Jexl表达式，得到结果
            jexlScript.execute(jexlContext);
            System.out.println(jexlContext.get("result"));
        return ss;
    }    
  
    public static void main(String[] args) {   
        String[] ss = createUUIDs(5);   
        for (int i = 0; i < ss.length; i++) {   
            System.out.println("ss["+i+"]====="+ss[i]);   
        }   
    }   
}  
