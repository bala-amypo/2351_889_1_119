package com.example.demo.service.serviceimpl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepo;
    private final UserPortfolioRepository portfolioRepo;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepo,
                                    UserPortfolioRepository portfolioRepo) {
        this.thresholdRepo = thresholdRepo;
        this.portfolioRepo = portfolioRepo;
    }

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {
        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        threshold.setPortfolio(portfolio);
        return thresholdRepo.save(threshold);
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {
        return thresholdRepo.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }
}
