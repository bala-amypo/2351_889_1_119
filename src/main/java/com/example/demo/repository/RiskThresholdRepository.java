package com.example.demo.repository;

import com.example.demo.model.RiskThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {
    @Query("SELECT rt FROM RiskThreshold rt WHERE rt.active = true")
    List<RiskThreshold> findByActiveTrue();
}