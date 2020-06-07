package cn.moonshotacademy.scp.vendingmachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.moonshotacademy.scp.vendingmachine.dao.ProductDAO;
import cn.moonshotacademy.scp.vendingmachine.model.ProductDTO;
import cn.moonshotacademy.scp.vendingmachine.vo.ProductVO;
import cn.moonshotacademy.scp.vendingmachine.vo.RandomVO;
import lombok.Data;

@Data
@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public ProductVO getProducts(Integer test){
        List<ProductDTO> productDTOList = this.productDAO.findByTest(test);
        ProductVO productVO = new ProductVO();
        productVO.setProducts(productDTOList);
        productVO.setRandomBox(new RandomVO());
        return productVO;
    }
}