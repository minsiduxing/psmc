package priv.guochun.psmc.system.framework.upload.factory;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MyCommonsMultipartResolverFactory
{
    public final static  Logger logger  = LoggerFactory.getLogger(MyCommonsMultipartResolverFactory.class.getName());
    private final static MyCommonsMultipartResolverFactory instance  = new MyCommonsMultipartResolverFactory();
    
    
    private MyCommonsMultipartResolverFactory(){
        
    }
    
    public CommonsMultipartResolver createCommonsMultipartResolver(HttpServletRequest request){       
        logger.debug("create init CommonsMultipartResolver ");
        return new CommonsMultipartResolver(request.getSession().getServletContext()); 
    }
    
    public static MyCommonsMultipartResolverFactory getInstance(){
        return instance;
    }
    
}
