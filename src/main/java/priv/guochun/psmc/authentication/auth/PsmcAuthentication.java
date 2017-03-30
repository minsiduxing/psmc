package priv.guochun.psmc.authentication.auth;

import java.util.List;
import java.util.Map;

import org.springframework.cache.Cache;

import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

public class PsmcAuthentication
{
    
    /**
     * 鉴权,检验当前角色是否拥有该资源的业务操作许可的验证
     * @param RoleUuid
     * @param resourceName
     * @param operate
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean authentication(String RoleUuid,String resourceName,String operate){
        StringBuffer visitKey = new StringBuffer();
        visitKey.append(RoleUuid+"_"+resourceName+"_"+operate);
        boolean isAuth = false;
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory)MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE, List.class);
        for(int i = 0;i<list.size();i++){
            Map<?,?> map = list.get(i);
            if(visitKey.toString().equals(map.get("R_CLASS_METHOD").toString()))
            {
                isAuth =true;
                break;
            }
        }
        return isAuth;
    }
    
    /**
     *  鉴权,检验当前角色是否拥有该资源的业务操作许可的验证
     * @param RoleUuid
     * @param operateNo
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean authentication(String RoleUuid,String operateNo){
        StringBuffer visitKey = new StringBuffer();
        visitKey.append(RoleUuid+"_"+operateNo);
        boolean isAuth = false;
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory)MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE, List.class);
        for(int i = 0;i<list.size();i++){
            Map<?,?> map = list.get(i);
            if(visitKey.toString().equals(map.get("R_OPERATE_NO").toString()))
            {
                isAuth =true;
                break;
            }
        }
        return isAuth;
    }
    
}
