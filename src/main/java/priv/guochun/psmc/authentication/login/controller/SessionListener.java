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
		HttpSession session = arg0.getSession();
		ServletContext application = session.getServletContext();
		// 在application范围由一个HashSet集保存所有的session
		HashSet sessions = (HashSet)application.getAttribute("sessions");
		if(null == sessions){
			sessions = new HashSet();
		}
		// 将新创建的session添加到HashSet集合中
        sessions.add(session);
        application.setAttribute("sessions", sessions);
        //获取集合的大小即（在线人数）
        int sessionsNum = null != sessions ? sessions.size() : 0;
        application.setAttribute("sessionsNum", sessionsNum);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
        ServletContext application = session.getServletContext();
        HashSet sessions = (HashSet) application.getAttribute("sessions");
        // 销毁的session均从HashSet集中移除
        sessions.remove(session);
        application.setAttribute("sessions", sessions);
      //获取集合的大小即（在线人数）
        int sessionsNum = null != sessions ? sessions.size() : 0;
        application.setAttribute("sessionsNum", sessionsNum);
	}

}
