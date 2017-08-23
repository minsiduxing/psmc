package priv.guochun.psmc.authentication.login.controller;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * SessionListener
 * 通过实现HttpSessionListener接口来实现获取系统当前在线人数的功能
 * @author Youngman 2017-7-5
 */
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
        ServletContext application = session.getServletContext();
        HashSet sessions = (HashSet) application.getAttribute("sessions");
        if(null != sessions && sessions.size() > 0){
        	
            sessions.remove(session);
            application.setAttribute("sessions", sessions);
            
            int sessionsNum = null != sessions ? sessions.size() : 0;
            application.removeAttribute("sessionsNum");
            application.setAttribute("sessionsNum", sessionsNum);
        }else{
        	application.removeAttribute("sessionsNum");
            application.setAttribute("sessionsNum", 0);
        }
        
	}

}
