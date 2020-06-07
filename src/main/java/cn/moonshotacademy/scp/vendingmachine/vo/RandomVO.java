package cn.moonshotacademy.scp.vendingmachine.vo;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class RandomVO {
    @Value("Random Box")
    String name;

    Integer[] ids;

    Double price;

    @Value("/api/img/94d4aef90820265861855512ea9f4164.png")
    String imageUrl;

    Integer test;

}