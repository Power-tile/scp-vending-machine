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
        System.out.println("--- Session Created ---- ");

        HttpSession session = event.getSession();
        session.setMaxInactiveInterval(600);
        System.out.println("createdSessionId: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) throws ClassCastException {
        System.out.println("--- Session Destroyed ---");

        HttpSession session = event.getSession();
        System.out.println("deletedSessionId: " + session.getId());
    }
}