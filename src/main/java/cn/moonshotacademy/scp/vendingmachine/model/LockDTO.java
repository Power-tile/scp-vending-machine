package cn.moonshotacademy.scp.vendingmachine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "locks")
public class LockDTO {
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "count")
    private Integer count;

    @Column(name = "session_id")
    private String sessionId;
}