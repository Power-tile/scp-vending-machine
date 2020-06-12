package cn.moonshotacademy.scp.vendingmachine.listener;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
// import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session Created ---- ");

        // HttpSession session = event.getSession();
        // session.setMaxInactiveInterval(10);
        // System.out.println("Current Session: " + session.getId());

        // ServletContext application = session.getServletContext();
        // HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
        // if (sessions == null) {
        //     sessions = new HashSet<HttpSession>();
        //     application.setAttribute("sessions", sessions);
        // }
        // sessions.add(session);
        // System.out.println("Current available sessions: " + Integer.valueOf(sessions.size()).toString());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) throws ClassCastException {
        System.out.println("Session Destroyed ---");

        // HttpSession session = event.getSession();
        // System.out.println("deletedSessionId: " + session.getId());
        // System.out.println(session.getCreationTime());
        // System.out.println(session.getLastAccessedTime());

        // ServletContext application = session.getServletContext();
        // HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
        // sessions.remove(session);
    }
}