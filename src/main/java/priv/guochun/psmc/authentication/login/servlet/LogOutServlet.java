package priv.guochun.psmc.authentication.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    	HttpSession httpSession = request.getSession(false);//防止创建Session
    	if(null == httpSession){
    		response.sendRedirect(request.getContextPath()+"/login.jsp");
    		return;
    	}
    	httpSession.removeAttribute("user");
    	response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
}
