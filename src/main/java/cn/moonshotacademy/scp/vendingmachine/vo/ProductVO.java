package cn.moonshotacademy.scp.vendingmachine.vo;

import java.util.List;

import cn.moonshotacademy.scp.vendingmachine.model.ProductDTO;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ProductVO {
    List<ProductDTO> products;
    
    RandomVO randomBox;

}