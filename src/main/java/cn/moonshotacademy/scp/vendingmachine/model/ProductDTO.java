package cn.moonshotacademy.scp.vendingmachine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductDTO {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "production_date")
    private Date productionDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "random")
    private Integer random;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "test")
    private Integer test;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "session_id")
    private String sessionId;
}