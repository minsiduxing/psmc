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

import priv.guochun.psmc.authentication.login.model.User;

public class LoginFilter implements Filter
{

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
        
        String suffix =  null;
        if(requestUrl.indexOf(".") != -1)
            suffix = requestUrl.substring(requestUrl.lastIndexOf("."),requestUrl.length());
        else
            suffix="";
        String vagueStr = "*"+suffix;
        for (String page : excludedPageArray) {//判断是否在过滤url之外     
            if(page.equals(requestUrl) || page.equals(vagueStr)){     
            isExcludedPage = true;     
            break;     
            }
        }     
        if(isExcludedPage){
            chain.doFilter(httpServletRequest, httpServletResponse);
        }else{
            HttpSession httpSession = httpServletRequest.getSession();
            User user = (User)httpSession.getAttribute("user");
            String ajaxRequest = httpServletRequest.getHeader("x-requested-with");
            String cPath = httpServletRequest.getServletContext().getContextPath();
            
            if(user == null){
                    String loginUrl =cPath+"/login.jsp";
                if(StringUtils.isNotBlank(ajaxRequest)){ //表明是ajax请求
                    httpServletResponse.setHeader("sessionstatus", "timeout");//在响应头设置session状态 
                    httpServletResponse.setHeader("sessionTimeoutUrl", loginUrl);
                    httpServletResponse.getWriter().print("timeout"); //打印一个返回值
                }else{
                    String sessionTimeOutUrl =cPath+"/sessionTimeout.jsp";
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
