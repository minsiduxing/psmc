package priv.guochun.psmc.authentication.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.login.model.User;

public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected static final  Logger logger  = LoggerFactory.getLogger(LoginServlet.class);

    public LogOutServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginurl = response.encodeRedirectURL(request.getContextPath()+"/login.jsp");
        HttpSession httpSession = request.getSession(false);//防止创建Session
    	if(null == httpSession){
    	    response.sendRedirect(loginurl);
    		return;
    	}
    	User loginOutUser = (User)httpSession.getAttribute("user");
    	if(loginOutUser!=null)
    	{
    		Cookie[] cookies = request.getCookies();
	   		if(null!=cookies ){
	   			 //遍历cookies数组
	   			 for(Cookie cookie: cookies){
	   				 if("userID".equals(cookie.getName()))
	   				 {
	   					cookie.setMaxAge(0);
	  					 cookie.setPath("/");
	  					 response.addCookie(cookie);
	  					 break;
	   				 }
	   			 }
	   		}
    		httpSession.removeAttribute("user");
    		logger.info("---------------用户"+loginOutUser.getAccountName()+"退出系统！");
    		logger.info("---------------清除了id为"+httpSession.getId()+"的session！");
    	}
    	
    	httpSession.invalidate();
    	response.sendRedirect(loginurl);
    }
}
