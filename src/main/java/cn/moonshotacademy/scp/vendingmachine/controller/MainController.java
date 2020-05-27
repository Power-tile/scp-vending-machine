package cn.moonshotacademy.scp.vendingmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/dev")
    public String devPage(Model m) {
        return "html/index-dev.html";
    }

    @RequestMapping("/")
    public String mainPage(Model m) {
        return "html/index.html";
    }
}