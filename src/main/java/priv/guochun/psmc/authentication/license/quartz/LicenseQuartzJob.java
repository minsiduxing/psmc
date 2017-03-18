package priv.guochun.psmc.authentication.license.quartz;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.license.sevice.LicenseReaderService;
import priv.guochun.psmc.system.framework.quartz.MyJob;


public class LicenseQuartzJob implements MyJob {
	
	private static final  Logger logger  = LoggerFactory.getLogger(LicenseQuartzJob.class);
	
	private LicenseReaderService licenseReaderService;
	
	
	@Override
	public void execute() {
	    Date currDate = new Date();
	    //logger.debug("开始计数系统运行时间.....");
	    licenseReaderService.work();
	    //logger.debug("结束计数系统运行时间.....");
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
