package cn.moonshotacademy.scp.vendingmachine.vo;

import java.util.List;

import cn.moonshotacademy.scp.vendingmachine.model.ProductDTO;
import lombok.Data;

@Data
public class ProductVO {
    List<ProductDTO> products;
    
    RandomVO randomBox;
}