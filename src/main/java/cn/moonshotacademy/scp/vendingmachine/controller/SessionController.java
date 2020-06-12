package cn.moonshotacademy.scp.vendingmachine.controller;

// import javax.servlet.http.Cookie;
// import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @RequestMapping("/session")
    public Object springSession(HttpSession session) {
        return session.getId();
    }
}