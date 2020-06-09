package cn.moonshotacademy.scp.vendingmachine.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private String getFormattedDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public List<ProductDTO> getExpiredProducts(Integer test) {
        return this.productDAO.findExpiredByTest(test, this.getFormattedDate());
    }

    public ProductVO getAvailableProducts(Integer test) {
        ProductVO productVO = new ProductVO();
        List<ProductDTO> productDTOList = this.productDAO.findAvailableByTestAndRandom(test, 0, this.getFormattedDate());

        productVO.setProducts(productDTOList);
        productVO.setRandomBox(this.getRandomVO(test));
        return productVO;
    }

    private RandomVO getRandomVO(Integer test) {
        RandomVO ret = new RandomVO();
        List<ProductDTO> randomDTOList = this.productDAO.findAvailableByTestAndRandom(test, 1, this.getFormattedDate());
            
        Double totalPrice = 0.0;
        Integer[] retIds = new Integer[randomDTOList.size()];
        for (int i = 0; i < randomDTOList.size(); i++) {
            retIds[i] = randomDTOList.get(i).getId();
            totalPrice += randomDTOList.get(i).getPrice();
        }

        ret.setIds(retIds);
        ret.setPrice(Double.valueOf(Math.ceil(totalPrice / randomDTOList.size())));
        ret.setTest(test);
        return ret;
    }
}