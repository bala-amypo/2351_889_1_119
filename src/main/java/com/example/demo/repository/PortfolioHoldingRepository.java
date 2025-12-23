package com.example.demo.repository;

import com.example.demo.model.PortfolioHolding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PortfolioHoldingRepository extends JpaRepository<PortfolioHolding, Long> {
    @Query("SELECT ph FROM PortfolioHolding ph WHERE ph.portfolio.id = :portfolioId")
    List<PortfolioHolding> findByPortfolioId(@Param("portfolioId") Long portfolioId);
}