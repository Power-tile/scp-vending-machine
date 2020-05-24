package cn.moonshotacademy.scp.vendingmachine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public String testMethod() {
        return "Hello, World!";
    }
}