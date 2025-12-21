package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import java.util.List;

public interface RiskThresholdService {

    RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold);

    RiskThreshold getThresholdForPortfolio(Long portfolioId);

    RiskThreshold getThresholdById(Long id);

    List<RiskThreshold> getAllThresholds();

    RiskThreshold getActiveThreshold();
}
