package com.example.demo.repository;  // Fixed line

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RiskAnalysisResult;  // Adjust model as needed

@Repository
public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult, Long> {
}
