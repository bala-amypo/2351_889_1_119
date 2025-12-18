package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RiskAnalysisResult;

public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult, Long> {
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);  // Add custom query
}
