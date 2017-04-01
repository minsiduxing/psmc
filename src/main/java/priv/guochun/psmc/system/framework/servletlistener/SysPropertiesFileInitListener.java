package priv.guochun.psmc.system.framework.servletlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.util.SystemPropertiesUtil;

public class SysPropertiesFileInitListener implements ServletContextListener
{

    private final static Logger logger  = LoggerFactory.getLogger(SysPropertiesFileInitListener.class.getName());
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0){}
    
    @Override
    public void contextInitialized(ServletContextEvent contextEvent){
        ServletContext context = contextEvent.getServletContext();
        String csssuffix = context.getInitParameter("csssuffix").toString();
        String jssuffix = context.getInitParameter("jssuffix").toString();

        context.setAttribute("csssuffix", csssuffix);
        context.setAttribute("jssuffix", jssuffix);
        
        Object obj = context.getInitParameter("systemPropertiesFileName");
        if(obj != null && !"".equals(obj.toString())){
            SystemPropertiesUtil.loadPropertiesInit(obj.toString());
        }else
            logger.error("systemPropertiesFileName  Does not exist,please add init-param 'systemPropertiesFileName' in web.xml.........");
       
    }

}
