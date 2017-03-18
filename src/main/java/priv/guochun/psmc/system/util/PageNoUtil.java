package priv.guochun.psmc.system.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class PageNoUtil {
    /** 
     
     * @param             session :一个会话 
 
     * @param            hql:是需要执行的hql语句， 
 
     * @param            offset 设置开始位置 
 
     * @param              length:读取记录条数 
 
     * return             返回结果集List表示一个泛型的List 
 
     */  
    public static List getList( Session session , String hql , int offset, int length){  
  
       Query q = session.createQuery(hql);  
  
       q.setFirstResult(offset);  
  
       q.setMaxResults(length);  
       
       q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
  
       List list = q.list();  
  
       return list;  
  
    }  
}
