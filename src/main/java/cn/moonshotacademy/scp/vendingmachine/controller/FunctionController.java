package cn.moonshotacademy.scp.vendingmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunctionController {
    @RequestMapping("/function/hash")
    public String hashPage(Model m) {
        return "/html/hashcode.html";
    }
}