import org.springframework.data.jpa.repository.JpaRepository;
package com.example.demo.repository;
import com.example.demo.model.PortfolioHolding;

@Repository
public interface PortfolioHoldingRepository extends JpaRepository<PortfolioHoliding,Long>{
    
}