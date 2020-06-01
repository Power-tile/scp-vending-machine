package cn.moonshotacademy.scp.vendingmachine.dao;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.moonshotacademy.scp.vendingmachine.model.ProductDTO;

@Repository
public interface ProductDAO extends JpaRepository<ProductDTO, Integer> {
    // There are already default methods for query. For more information, see https://www.jianshu.com/p/d41a04b367ed
    // @Query(value = "SELECT * from products WHERE id=:id", nativeQuery = true)
    // List<ProductDTO> findAllById(Integer id);
}