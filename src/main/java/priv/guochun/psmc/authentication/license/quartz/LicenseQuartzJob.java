package priv.guochun.psmc.authentication.license.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import priv.guochun.psmc.authentication.license.sevice.LicenseReaderService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;


public class LicenseQuartzJob  extends QuartzJobBean {
	
	private static final  Logger logger  = LoggerFactory.getLogger(LicenseQuartzJob.class);
	@Autowired
	private LicenseReaderService licenseReaderService;
	
	
	public LicenseQuartzJob(){
	    Object obj = MySpringApplicationContext.getObject("licenseReaderService");
        if(obj !=null)
            this.licenseReaderService = (LicenseReaderService)obj;
        else
            logger.warn("bean id licenseReaderService not in spring context");
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
	    if(licenseReaderService!=null)
	    {
	        logger.debug("LicenseQuartzJob start! ");
	        licenseReaderService.work();
	        logger.debug("LicenseQuartzJob end! ");
	    }
	        
	}

    public LicenseReaderService getLicenseReaderService()
    {
        return licenseReaderService;
    }


    public void setLicenseReaderService(LicenseReaderService licenseReaderService)
    {
        this.licenseReaderService = licenseReaderService;
    }


  
	
	
	

   
	
	
	
	

	
	
}
