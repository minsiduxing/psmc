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
import priv.guochun.psmc.authentication.auth.PsmcAuthentication;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.common.log.factory.TSysOperLogMapFactory;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.cache.PsmcInitCacheTool;
import priv.guochun.psmc.system.framework.util.LogTypeEnum;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;

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
   

    @SuppressWarnings("unchecked")
	@Override
    public void afterAdvice(JoinPoint jionpoint)
    {
    	User user = (User)session.getAttribute("user");
        String roleUuid = user.getRoleUuid();
        Signature signature = jionpoint.getSignature();
        String  whatClassName = signature.getDeclaringTypeName();
        String  whatMethodName = signature.getName();
        
        
        String personName = user.getPersonName();
        
        TSysOperLog sysOperLog = new TSysOperLog();
        sysOperLog.setUuid(UUIDGenerator.createUUID());
        sysOperLog.setLogType(LogTypeEnum.LogTypeSysOper2.getIndex());
        sysOperLog.setLogTypeName(LogTypeEnum.LogTypeSysOper2.getName());
        sysOperLog.setLogSubType(LogTypeEnum.LogTypeSysOper2_3.getIndex());
        sysOperLog.setLogSubTypeName(LogTypeEnum.LogTypeSysOper2_3.getName());
        sysOperLog.setOperid(user.getUserUuid());
        sysOperLog.setOpername(personName);
        sysOperLog.setOperDate(DateUtil.getCurrentTimstamp());
        
        
        StringBuffer visitKey = new StringBuffer();
        visitKey.append(roleUuid+"_"+whatClassName+"_"+whatMethodName);
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory)MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSystem();
        List<Map<?,?>> list = cache.get(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE, List.class);
        for(int i = 0;i<list.size();i++){
            Map<?,?> map = list.get(i);
            if(visitKey.toString().equals(map.get("R_CLASS_METHOD").toString()))
            {
                String RESOURCE_NAME = map.get("RESOURCE_NAME").toString();
                String OPERATE_NAME = map.get("OPERATE_NAME").toString();
                StringBuffer operResultDesc = new StringBuffer();
                operResultDesc.append("对");
                operResultDesc.append(RESOURCE_NAME);
                operResultDesc.append("进行");
                operResultDesc.append(OPERATE_NAME);
                operResultDesc.append("操作");
                sysOperLog.setOperResultDesc(operResultDesc.toString());
            }
        }
        
        TSysOperLogMapFactory.getInstance().getTSysOperLog().put(sysOperLog.getUuid(), sysOperLog);
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
