package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    public RiskThreshold getByPortfolioId(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId)
                .orElse(null);
    }
}
