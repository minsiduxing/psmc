package priv.guochun.psmc.authentication.login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.login.model.User;

public class LoginFilter implements Filter
{
	protected static final  Logger logger  = LoggerFactory.getLogger(LoginFilter.class);
    
    private String excludedPages;       
    private String[] excludedPageArray;     
    
    @Override
    public void init(FilterConfig fConfig) throws ServletException {     
        excludedPages = fConfig.getInitParameter("excludedPages");     
        if (StringUtils.isNotBlank(excludedPages)) {     
            excludedPageArray = excludedPages.split(",");     
        }     
        return;     
     }      

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request ;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response ;
        
        boolean isExcludedPage = false;     
        String requestUrl = httpServletRequest.getServletPath();
        
        String suffix =  "*";
        if(requestUrl.indexOf(".") != -1)
            suffix += requestUrl.substring(requestUrl.lastIndexOf("."),requestUrl.length());
        
        //判断是否在过滤url之外     
        for (String page : excludedPageArray) {
            if(page.equals(requestUrl) || page.equals(suffix)){     
            isExcludedPage = true;     
            break;     
            }
        }     
        if(isExcludedPage){
            chain.doFilter(httpServletRequest, httpServletResponse);
        }else{
            logger.debug("==================================================");
            logger.debug("request.getRemoteHost() {}",httpServletRequest.getRemoteHost());
            logger.debug("getRemotePort() {}",httpServletRequest.getRemotePort());
            logger.debug("request.getRemoteAddr() {}",httpServletRequest.getRemoteAddr());
            logger.debug("requestedSessionId: {}",httpServletRequest.getRequestedSessionId());
            logger.debug("getRequestUrl----------: {}",httpServletRequest.getRequestURL().toString());
            logger.debug("getRealPath----------: {}",httpServletRequest.getRealPath("/"));
            
            
            HttpSession httpSession = httpServletRequest.getSession();
            User user = (User)httpSession.getAttribute("user");
            String ajaxRequest = httpServletRequest.getHeader("x-requested-with");
            String cPath = httpServletRequest.getServletContext().getContextPath();
            
            if(user == null){
                String loginUrl =httpServletResponse.encodeRedirectURL(cPath+"/login.jsp");
                if(StringUtils.isNotBlank(ajaxRequest)){ //表明是ajax请求
                	//在响应头设置session状态 
                    httpServletResponse.setHeader("sessionstatus", "timeout");
                    httpServletResponse.setHeader("sessionTimeoutUrl", loginUrl);
                    httpServletResponse.getWriter().print("timeout"); //打印一个返回值
                }else{
                	//进行url重写，防止客户端关闭cookie后系统无法正常使用
                    String sessionTimeOutUrl =httpServletResponse.encodeRedirectURL(cPath+"/sessionTimeout.jsp");
                    logger.debug("sessionTimeOutUrl: {}",sessionTimeOutUrl);
                    httpServletResponse.sendRedirect(sessionTimeOutUrl);
                    
                }    
            }
            else
                chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
        
    }

    

}
