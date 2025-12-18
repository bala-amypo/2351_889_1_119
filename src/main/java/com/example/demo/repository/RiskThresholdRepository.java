package com.example.demo.model;

import com.example.demo.model.RiskThreshold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {

    RiskThreshold findByActiveTrue();
}
