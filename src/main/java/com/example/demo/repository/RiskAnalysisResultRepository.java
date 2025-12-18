package com.example.demo.model;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult, Long> {

    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}
