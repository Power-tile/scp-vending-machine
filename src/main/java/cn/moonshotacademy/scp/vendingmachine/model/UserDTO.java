package cn.moonshotacademy.scp.vendingmachine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserDTO {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "wechat_name")
    private String wechatName;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private Integer admin;
}