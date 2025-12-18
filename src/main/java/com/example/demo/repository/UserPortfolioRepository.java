import org.springframework.data.jpa.repository.JpaRepository;
package com.example.demo.repository;
import com.example.demo.model.UserPortfolio;

@Repository
public interface UserPortfolioRepository extends JpaRepository<UserPortfolio,Long>{
    
}