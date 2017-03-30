package priv.guochun.psmc.authentication.aop.advice;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.aop.exception.NotAllowedException;
import priv.guochun.psmc.authentication.auth.PsmcAuthentication;
import priv.guochun.psmc.authentication.login.model.User;
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
        boolean isAuth = PsmcAuthentication.authentication(roleUuid,whatClassName,whatMethodName);
        logger.debug("beforeAdvice result"+"["+isAuth+"]:"+jionpoint.getStaticPart());
        if(!isAuth){
            StringBuffer sBuffer = new StringBuffer();
            sBuffer.append("用户");
            sBuffer.append(user.getAccountName());
            sBuffer.append("无权限进行资源操作[");
            sBuffer.append(whatClassName);
            sBuffer.append(".");
            sBuffer.append(whatMethodName);
            sBuffer.append("]");
            logger.warn(sBuffer.toString());
            throw new NotAllowedException(sBuffer.toString());
        }
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
