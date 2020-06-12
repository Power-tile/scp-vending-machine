package cn.moonshotacademy.scp.vendingmachine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import cn.moonshotacademy.scp.vendingmachine.service.ProductService;
import cn.moonshotacademy.scp.vendingmachine.vo.ProductVO;

@Controller
public class APIController {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    LogDAO logDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    ProductService productService;

    @RequestMapping("/api/img/{name}")
    public String apiGetImage(@PathVariable("name") String imgName) {
        System.out.println(imgName);
        return "/img/" + imgName;
    }

    @RequestMapping("/api/product/available")
    public @ResponseBody ProductVO getAvailableProduct(HttpSession session) {
        return productService.getAvailableProducts(0);
    }

    @RequestMapping("/api/product/test/available")
    public @ResponseBody ProductVO getAvailableTestProduct(HttpSession session) {
        return productService.getAvailableProducts(1);
    }

    @RequestMapping("/api/product/expired")
    public @ResponseBody List<ProductDTO> getExpiredProduct(HttpSession session) {
        return productService.getExpiredProducts(0);
    }

    @RequestMapping("/api/product/test/expired")
    public @ResponseBody List<ProductDTO> getExpiredTestProduct(HttpSession session) {
        return productService.getExpiredProducts(1);
    }
}