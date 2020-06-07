package cn.moonshotacademy.scp.vendingmachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.moonshotacademy.scp.vendingmachine.dao.ProductDAO;
import cn.moonshotacademy.scp.vendingmachine.model.ProductDTO;
import cn.moonshotacademy.scp.vendingmachine.vo.ProductVO;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public ProductVO getProducts(Integer test){
        List<ProductDTO> productDTOList = this.productDAO.findByTest(test);
        ProductVO productVO = new ProductVO();
        productVO.setProducts(productDTOList);
        return productVO;
    }
}