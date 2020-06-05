package cn.moonshotacademy.scp.vendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.moonshotacademy.scp.vendingmachine.dao.LogDAO;
import cn.moonshotacademy.scp.vendingmachine.dao.ProductDAO;
import cn.moonshotacademy.scp.vendingmachine.dao.UserDAO;
import cn.moonshotacademy.scp.vendingmachine.model.LogDTO;
import cn.moonshotacademy.scp.vendingmachine.model.ProductDTO;
import cn.moonshotacademy.scp.vendingmachine.model.UserDTO;

@Controller
public class APIController {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    LogDAO logDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/api/test")
    public @ResponseBody List<LogDTO> apiTest() {
        return logDAO.findAll();
    }

    @RequestMapping("/api/img/{name}")
    public String apiGetImage(@PathVariable("name") String imgName) {
        System.out.println(imgName);
        return "/img/" + imgName;
    }
}