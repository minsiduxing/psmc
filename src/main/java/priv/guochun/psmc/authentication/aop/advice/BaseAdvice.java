package priv.guochun.psmc.authentication.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface BaseAdvice
{
    /**
     * 前置通知        
     * <p>Description:<p>
     * @param jionpoint
     * @author guochun 2017-3-2
     */
    public void beforeAdvice(JoinPoint jionpoint);
    
    /**
     * 后置通知（不论连接点是否执行成功都执行该方法）
     * <p>Description:<p>
     * @param jionpoint
     * @author guochun 2017-3-2
     */
    public void afterAdvice(JoinPoint jionpoint);
    
    /**
     * 连接点正常返回的时候执行该方法
     * <p>Description:<p>
     * @param jionpoint
     * @author guochun 2017-3-2
     */
    public void afterRetunAdvice(JoinPoint jionpoint);
    
    
    /**
     * 异常通知
     * <p>Description:<p>
     * @param jionpoint
     * @author guochun 2017-3-2
     */
    public void throwingAdvice(JoinPoint jionpoint, Exception e);
    
    /**
     * 环绕通知
     * <p>Description:<p>
     * @param jionpoint
     * @throws Throwable
     * @author guochun 2017-3-2
     */
    public Object aroundAdvice(ProceedingJoinPoint jionpoint) throws Throwable;
    
    
}
