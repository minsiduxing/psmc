package priv.guochun.psmc.system.framework.filter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.util.DateUtil;

/**
 * 对系统中所有的请求进行拦截判断，如果主机时间超过设置的时间，则不进行响应
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2016</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2016-11-3
 */

public class MyLicenseFilter implements Filter  {

	private Boolean enable = null;
	
	private String invildDate = null;
	
	protected static final  Logger logger  = LoggerFactory.getLogger(MyLicenseFilter.class);

	@Override
	public void destroy() {
		logger.debug("MyLicenseFilter destroy over.... ");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest)request;  
	    
		if(enable){
		    try
            {
                Date invildD = DateUtil.getDate(invildDate, DateUtil.dateFormat_contants);
                Date curD = new Date();
                if(invildD.getTime()<curD.getTime()){
                    logger.debug("试用期时间已到,请更换license.........");
                    return;
                }
            }
            catch (ParseException e){
                e.printStackTrace();
                return;
            }
	        chain.doFilter(req, response);  
		}else
		    chain.doFilter(req, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	    invildDate = arg0.getInitParameter("invildDate");
		enable =  Boolean.parseBoolean(arg0.getInitParameter("enable"));
		logger.debug("MyLicenseFilter init over.... ");
		
	}

	
	
	
}
