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

    public ProductVO getProducts(Integer test) {
        List<ProductDTO> productDTOList = this.productDAO.findByTestAndRandom(test, 0);
        ProductVO productVO = new ProductVO();
        productVO.setProducts(productDTOList);
        productVO.setRandomBox(this.getRandomVO(test));
        return productVO;
    }

    private RandomVO getRandomVO(Integer test) {
        RandomVO ret = new RandomVO();
        List<ProductDTO> randomDTOList = this.productDAO.findByTestAndRandom(test, 1);
        Integer[] ids = new Integer[randomDTOList.size()];
        Double totalPrice = 0.0;
        for (int i = 0; i < randomDTOList.size(); i++) {
            ids[i] = randomDTOList.get(i).getId();
            totalPrice += randomDTOList.get(i).getPrice();
        }
        ret.setIds(ids);
        ret.setPrice(totalPrice / randomDTOList.size());
        ret.setTest(test);
        return ret;
    }
}