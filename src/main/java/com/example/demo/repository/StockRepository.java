import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Stock;
package com.example.demo.repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long>{
    
}