package priv.guochun.psmc.system.common.log.quartz;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import priv.guochun.psmc.system.common.log.factory.TSysOperLogMapFactory;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.common.log.service.TSysOperLogService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

/**
 * 系统日志定时持久化任务类
 * @author guochun
 *
 */
public class LogOperTask extends QuartzJobBean
{
    protected static final  Logger logger  = LoggerFactory.getLogger(LogOperTask.class);

    private TSysOperLogService tSysOperLogService;
    
    
    public LogOperTask (){
        Object obj = MySpringApplicationContext.getObject("tSysOperLogService");
        if(obj !=null)
            this.tSysOperLogService = (TSysOperLogService)obj;
        else
            logger.warn("bean id tSysOperLogService not in spring context");
    }
    
	@Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
    	
    	Map<String,TSysOperLog> map = TSysOperLogMapFactory.getInstance().getTSysOperLog();
		Set set = map.keySet();
		if(set.size() == 0)
			return;
		logger.info("系统开始进行日志持久化操作,日志记录数:"+set.size());
		Iterator<String> iter = set.iterator();
		int flag=0;
    	while(iter.hasNext()){
    		String key = iter.next().toString();
    		try{
        		tSysOperLogService.save(map.get(key));
        	}catch(Exception e){
        		e.printStackTrace();
        	}
    		iter.remove();
    		flag++;
    	}
    }

	public TSysOperLogService gettSysOperLogService() {
		return tSysOperLogService;
	}

	public void settSysOperLogService(TSysOperLogService tSysOperLogService) {
		this.tSysOperLogService = tSysOperLogService;
	}
  
	
    
}
