package priv.guochun.psmc.system.framework.cache;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

/**
 * 系统缓存定时加载任务入口
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2017-3-10
 */
public class InitCacheTask extends QuartzJobBean
{
    protected static final  Logger logger  = LoggerFactory.getLogger(InitCacheTask.class);

    private PsmcInitCacheTool psmcInitCacheTool;    
    
    public InitCacheTask (){
        Object obj = MySpringApplicationContext.getObject("psmcInitCacheTool");
        if(obj !=null)
            this.psmcInitCacheTool = (PsmcInitCacheTool)obj;
        else
            logger.warn("bean id psmcInitCacheTool not in spring context");
    }
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        if(psmcInitCacheTool!=null){
            logger.debug("InitCacheTask start! ");
            psmcInitCacheTool.resourcePermitOperatesInit();
            logger.debug("InitCacheTask end! ");
        }
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
