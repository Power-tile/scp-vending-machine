package cn.moonshotacademy.scp.vendingmachine.service;

import java.util.ArrayList;
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

    public ProductVO getProducts(Integer test) {
        return this.getProducts(test, true);
    }

    public ProductVO getProducts(Integer test, boolean available) {
        ProductVO productVO = new ProductVO();
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        if(available){
            productDTOList = this.productDAO.findAvailableByTestAndRandom(test, 0, new Date());
        } else {
            productDTOList = this.productDAO.findExpiryByTestAndRandom(test, 0, new Date());
        }
        // int cnt = 0;
        // while(cnt<productDTOList.size()){
        //     if(this.available(productDTOList.get(cnt))==available){
        //         cnt++;
        //     } else {
        //         productDTOList.remove(cnt);
        //     }
        // }

        productVO.setProducts(productDTOList);
        productVO.setRandomBox(this.getRandomVO(test,available));
        return productVO;
    }

    private RandomVO getRandomVO(Integer test, boolean available) {
        RandomVO ret = new RandomVO();
        List<ProductDTO> randomDTOList = new ArrayList<ProductDTO>();
        if(available){
            randomDTOList = this.productDAO.findAvailableByTestAndRandom(test, 1, new Date());
        } else {
            randomDTOList = this.productDAO.findExpiryByTestAndRandom(test, 1, new Date());
        }
        ArrayList<Integer> ids = new ArrayList<Integer>();
        Double totalPrice = 0.0;
        for (int i = 0; i < randomDTOList.size(); i++) {
            ids.add(randomDTOList.get(i).getId());
        }

        Integer[] retIds = new Integer[ids.size()];
        for(int i=0;i<ids.size();i++){
            retIds[i]=ids.get(i);
        }
        ret.setIds(retIds);
        ret.setPrice(totalPrice / randomDTOList.size());
        ret.setTest(test);
        return ret;
    }

    private boolean available(ProductDTO productDTO) {
        Date productDate = productDTO.getExpiryDate();
        Date currentDate = new Date();
        // System.out.println(productDTO.getName());
        // System.out.println(productDate);
        if (productDate.compareTo(currentDate) == 1) {
            return true;
        } else {
            return false;
        }
    }
}