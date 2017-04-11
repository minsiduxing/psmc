package priv.guochun.psmc.authentication.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected static final  Logger logger  = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession httpSession = request.getSession();
	        String msg;
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String loginurl = response.encodeRedirectURL(request.getContextPath()+"/login.jsp");
            String sucurl = response.encodeRedirectURL(request.getContextPath()+"/authentication/loginController.do?method=entrance");
	        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
	                msg="用户名或密码为空,无法登录!";
	                request.setAttribute("msg", msg);
	                response.sendRedirect(loginurl);
	        }else{
	            LoginService service = (LoginService)MySpringApplicationContext.getObject("loginService");
                String returnValue = service.isVaild(username, password);
	            if("success".equals(returnValue)){
	            	User user = service.buildUser(username);
	            	//httpSession.removeAttribute("user");
	                httpSession.setAttribute("user",user);
	                response.sendRedirect(sucurl);
	                
	            }else{
                    response.sendRedirect(loginurl);
	            }
	        }
	}

}
