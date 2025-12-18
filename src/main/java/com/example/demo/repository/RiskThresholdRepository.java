import org.springframework.data.jpa.repository.JpaRepository;
package com.example.demo.repository;
import com.example.demo.model.RiskThreshold;

@Repository
public interface RiskThresholdRepository extends JpaRepository<RiskThreshold,Long>{
    
}