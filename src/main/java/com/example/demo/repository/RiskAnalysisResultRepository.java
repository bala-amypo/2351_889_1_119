
import org.springframework.data.jpa.repository.JpaRepository;
package com.example.demo.repository;
import com.example.demo.model.RiskAnalysisResult;

@Repository
public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult,Long>{
    
}