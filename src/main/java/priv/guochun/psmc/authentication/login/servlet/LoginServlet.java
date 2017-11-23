package priv.guochun.psmc.authentication.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
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
import priv.guochun.psmc.system.util.JsonUtil;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected static final  Logger logger  = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	@SuppressWarnings({ })
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession httpSession = request.getSession();
	        //在这里创建application域为了存储成功登录的用户session集合（统计当前系统的在线人数）
	        ServletContext application = httpSession.getServletContext();
	        //由于登录失败要返回前台json数据所以在此声明返回数据格式为json
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");
	        //返回消息
	        String msg;
	        //由于要转json格式，所以需要定义一个map
	        Map <String,String> resMap ;
	        String username = request.getParameter("username");
	        String password = request.getParameter("ppassword");
	        String transmiturl = request.getParameter("transmiturl");
	        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
	                msg="用户名或密码为空,无法登录!";
	                resMap = new HashMap<String,String>();
	                resMap.put("msg", msg);
	                logger.info("--------------------用户登录系统失败！原因："+msg);
	        }else{
	        	if(httpSession.getAttribute("user")!=null){
	        		 if(StringUtils.isNotBlank(transmiturl)) {
			        	 	request.getRequestDispatcher(transmiturl).forward(request, response);
			        	 	return;
			         }else{
			        	 resMap = new HashMap<String,String>();
				         resMap.put("msg", "success");
				         PrintWriter pw =  response.getWriter();
					     pw.append(JsonUtil.convertToJSONObject(resMap).toString());
				         pw.close();
			         }
	        	}
	            LoginService service = (LoginService)MySpringApplicationContext.getObject("loginService");
                String returnValue = service.isVaild(username, password);
	            if("success".equals(returnValue)){
	            	User user = service.buildUser(username);
	            	logger.info("--------------------用户"+username +"的信息植入session容器成功！");
	             httpSession.setAttribute("user",user);
	             resMap = new HashMap<String,String>();
		         resMap.put("msg", "success");
		         logger.info("--------------------用户"+username +"成功登录系统！");
		         countLonin(application,httpSession);
		         if(StringUtils.isNotBlank(transmiturl)) {
		        	 	request.getRequestDispatcher(transmiturl).forward(request, response);
		        	 	return;
		         }
	            }else{
	            	  resMap = new HashMap<String,String>();
		          resMap.put("msg", returnValue);
		          logger.info("--------------------用户"+username +"登录系统失败！原因："+returnValue);
	            }  
	        }
	        PrintWriter pw =  response.getWriter();
	        pw.append(JsonUtil.convertToJSONObject(resMap).toString());
            pw.close();
	}
	
	@SuppressWarnings("unchecked")
	public void countLonin(ServletContext application,HttpSession httpSession) {
		Map<String,HttpSession> sessions = (HashMap<String,HttpSession>)application.getAttribute("sessions");
 		if(null == sessions){
 			sessions = new HashMap<String,HttpSession>();
 		}
         sessions.put(httpSession.getId(), httpSession);
         application.setAttribute("sessions", sessions);
         //获取集合的大小即（在线人数）
         int sessionsNum =sessions.size();
         application.setAttribute("sessionsNum", sessionsNum);
	}

}
