package cn.moonshotacademy.scp.vendingmachine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.moonshotacademy.scp.vendingmachine.model.LogDTO;

@Repository
public interface LogDAO extends JpaRepository<LogDTO, Integer> {
    
}