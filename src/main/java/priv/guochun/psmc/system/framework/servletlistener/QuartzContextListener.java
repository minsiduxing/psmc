package priv.guochun.psmc.system.framework.servletlistener;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wangtao
 * @date 2022/6/10
 */
public class QuartzContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        WebApplicationContext webApplicationContext = (WebApplicationContext) arg0
                .getServletContext()
                .getAttribute(
                        WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        SchedulerFactoryBean schedulerFactoryBean = (SchedulerFactoryBean) webApplicationContext
                .getBean("quartzScheduler");//配置文件里配置的quartz的beanId
        if(schedulerFactoryBean != null) {
            try {
                schedulerFactoryBean.destroy();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5000);//主线程暂停一定时间让quartz schedular执行shutdown
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("QuartzContextListener is initializing");
    }

}
