package com.example.demo.repository;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult, Long> {
    @Query("SELECT rar FROM RiskAnalysisResult rar WHERE rar.portfolio.id = :portfolioId")
    List<RiskAnalysisResult> findByPortfolioId(@Param("portfolioId") Long portfolioId);
}