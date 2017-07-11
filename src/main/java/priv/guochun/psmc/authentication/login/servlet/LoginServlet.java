package priv.guochun.psmc.authentication.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
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
	        //在这里创建application域为了存储成功登录的用户session集合（统计当前系统的在线人数）
	        ServletContext application = httpSession.getServletContext();
	        //由于登录失败要返回前台json数据所以在此声明返回数据格式为json
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json; charset=utf-8");
	        PrintWriter out = null;
	        //返回消息
	        String msg;
	        //由于要转json格式，所以需要定义一个map
	        Map <String,String> resMap ;
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
//	        String loginurl = response.encodeRedirectURL(request.getContextPath()+"/login.jsp");
//            String sucurl = response.encodeRedirectURL(request.getContextPath()+"/authentication/loginController.do?method=entrance");
	        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
	                msg="用户名或密码为空,无法登录!";
	                resMap = new HashMap<String,String>();
	                resMap.put("msg", msg);
//	                request.setAttribute("msg", msg);
//	                response.sendRedirect(loginurl);
	                out = response.getWriter();
	                logger.info("--------------------用户登录系统失败！原因："+msg);
	                out.print(JSONObject.valueToString(resMap));
	        }else{
	            LoginService service = (LoginService)MySpringApplicationContext.getObject("loginService");
                String returnValue = service.isVaild(username, password);
	            if("success".equals(returnValue)){
	            	User user = service.buildUser(username);
	            	//httpSession.removeAttribute("user");
	            	 logger.info("--------------------用户"+username +"的信息植入session容器成功！");
	                 httpSession.setAttribute("user",user);
	                 out = response.getWriter();
	                 resMap = new HashMap<String,String>();
		             resMap.put("msg", "success");
		             logger.info("--------------------用户"+username +"成功登录系统！");
		             out.print(JSONObject.valueToString(resMap));
		             // 在application范围由一个HashSet集保存所有的session
		     		 HashSet sessions = (HashSet)application.getAttribute("sessions");
		     		 if(null == sessions){
		     			 sessions = new HashSet();
		     		 }
		     		 // 将新创建的session添加到HashSet集合中
		             sessions.add(httpSession);
		             application.setAttribute("sessions", sessions);
		             //获取集合的大小即（在线人数）
		             int sessionsNum = null != sessions ? sessions.size() : 0;
		             application.setAttribute("sessionsNum", sessionsNum);
	            }else{
	            	  out = response.getWriter();
	            	  resMap = new HashMap<String,String>();
		              resMap.put("msg", returnValue);
		              logger.info("--------------------用户"+username +"登录系统失败！原因："+returnValue);
		              out.print(JSONObject.valueToString(resMap));
	            }
	        }
	}

}
