package priv.guochun.psmc.system.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.wrapper.GetHttpServletRequestWrapper;

/**
 * 解决get方式请求服务器时的URL中携带中文的乱码问题
 * @author Administrator
 *
 */

public class MyEncodingFilter implements Filter  {

	private Boolean enable = null;
	
	private String charset = null;
	
	protected static final  Logger logger  = LoggerFactory.getLogger(MyEncodingFilter.class);

	
	@Override
	public void destroy() {
		logger.debug("MyEncodingFilter destroy over.... ");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest)request;  
		if(enable){
			request.setCharacterEncoding(charset);  
	        response.setCharacterEncoding(charset); 
	        
//	        if(req.getMethod().equalsIgnoreCase("get"))  
//	        {  
	            req = new GetHttpServletRequestWrapper(req,charset);  
//	        }  
	        chain.doFilter(req, response);  
		}else
		    chain.doFilter(req, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		charset = arg0.getInitParameter("charset");
		enable =  Boolean.parseBoolean(arg0.getInitParameter("enable"));
		logger.debug("MyEncodingFilter init over.... ");
		
	}

	
	
	
}
