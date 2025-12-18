package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import java.util.List;

public interface RiskThresholdService {

    RiskThreshold createThreshold(RiskThreshold threshold);

    RiskThreshold getThresholdById(Long id);

    List<RiskThreshold> getAllThresholds();

    RiskThreshold getActiveThreshold();
}
