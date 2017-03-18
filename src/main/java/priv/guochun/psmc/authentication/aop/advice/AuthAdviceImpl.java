package priv.guochun.psmc.authentication.aop.advice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import priv.guochun.psmc.authentication.aop.exception.NotAllowedException;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.cache.PsmcInitCacheTool;

public class AuthAdviceImpl implements BaseAdvice
{
    protected static final  Logger logger  = LoggerFactory.getLogger(AuthAdviceImpl.class);
    
    private PsmcCacheFactory psmcCacheFactory;
    
    private PsmcInitCacheTool psmcInitCacheTool;
    
    @Autowired
    private HttpSession session;

    
    @Override
    public void beforeAdvice(JoinPoint jionpoint)
    {
        User user = (User)session.getAttribute("user");
        String roleUuid = user.getRoleUuid();
        Signature signature = jionpoint.getSignature();
        String  whatClassName = signature.getDeclaringTypeName();
        String  whatMethodName = signature.getName();
        boolean isAuth = authentication(roleUuid,whatClassName,whatMethodName);
        if(!isAuth){
            logger.warn("用户"+user.getAccountName()+"无权限进行资源操作["+whatClassName+"."+whatMethodName+"]");
            throw new NotAllowedException("用户"+user.getAccountName()+"无权限进行该操作,请联系管理员进行授权!");
        }
        logger.debug("beforeAdvice "+jionpoint.getStaticPart());
        
    }
    
    
    @SuppressWarnings({"unchecked" })
    private boolean authentication(String RoleUuid,String resourceName,String operate){
        String visitKey = RoleUuid+"_"+resourceName+"_"+operate;
        boolean isAuth = false;
        Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE, List.class);
        for(int i = 0;i<list.size();i++){
            Map<?,?> map = list.get(i);
            if(visitKey.equals(map.get("VISIT_KEY").toString()))
            {
                isAuth =true;
                break;
            }
        }
        return isAuth;
    }
    

    @Override
    public void afterAdvice(JoinPoint jionpoint)
    {
    
        
    }
    
    public void afterRetunAdvice(JoinPoint jionpoint){
     
    }

    @Override
    public void throwingAdvice(JoinPoint jionpoint, Exception e)
    {
       
    }

    @Override
    public Object aroundAdvice(ProceedingJoinPoint jionpoint) throws Throwable
    {
//        Object obj = jionpoint.proceed();
//        logger.info("target method return value "+obj);
//        return obj;
           return null;
    }


    public PsmcCacheFactory getPsmcCacheFactory()
    {
        return psmcCacheFactory;
    }


    public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory)
    {
        this.psmcCacheFactory = psmcCacheFactory;
    }


    public PsmcInitCacheTool getPsmcInitCacheTool()
    {
        return psmcInitCacheTool;
    }


    public void setPsmcInitCacheTool(PsmcInitCacheTool psmcInitCacheTool)
    {
        this.psmcInitCacheTool = psmcInitCacheTool;
    }
    
    
}
