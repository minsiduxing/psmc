package priv.guochun.psmc.system.framework.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.quartz.MyJob;

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
public class InitCacheTask implements MyJob
{
    protected static final  Logger logger  = LoggerFactory.getLogger(InitCacheTask.class);

    private PsmcInitCacheTool psmcInitCacheTool;

    @Override
    public void execute(){
        psmcInitCacheTool.resourcePermitOperatesInit();
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
