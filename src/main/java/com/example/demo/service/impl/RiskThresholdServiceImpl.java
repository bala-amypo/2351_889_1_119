package com.example.demo.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository,
                                    UserPortfolioRepository portfolioRepository) {
        this.thresholdRepository = thresholdRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {
        String role = SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities().iterator().next().getAuthority();

        if (!role.equals("ADMIN")) {
            throw new SecurityException("Only ADMIN can modify risk thresholds");
        }

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Invalid stock percentage");
        }

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        threshold.setPortfolio(portfolio);
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {
        return thresholdRepository.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }

}
