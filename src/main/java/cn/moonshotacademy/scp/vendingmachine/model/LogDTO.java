package cn.moonshotacademy.scp.vendingmachine.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "logs")
public class LogDTO {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "time")
    private Date time;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "type")
    private Integer type;

    @Column(name = "target_id")
    private Integer targetId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "test")
    private Integer test;
}