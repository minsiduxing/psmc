package priv.guochun.psmc.system.util;

import org.apache.commons.jexl3.*;

import java.util.HashMap;
import java.util.Map;
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
        return ss;
    }
  
    public static void main(String[] args) {   
        String[] ss = createUUIDs(5);   
        for (int i = 0; i < ss.length; i++) {   
            System.out.println("ss["+i+"]====="+ss[i]);   
        }

        Map<Object,Object> map = new HashMap<Object,Object>();
//        map.put("GRID_PEOPLE_COUNT", "1999");
//        map.put("ACTUAL_ISSUE_CERT_TOTAL", "6");
        boolean reusult = JetlUtil.execute("if(GRID_PEOPLE_COUNT<1000 || (GRID_PEOPLE_COUNT>=1000 && ACTUAL_ISSUE_CERT_TOTAL<5)){ if(GRID_PEOPLE_COUNT/200-ACTUAL_ISSUE_CERT_TOTAL>0){result=true}else{result=false} } else{ if((GRID_PEOPLE_COUNT-1000)/500-(ACTUAL_ISSUE_CERT_TOTAL-5)>0){result=true}else{result=false} }",map);
        System.out.println(reusult);
    }   
}  
