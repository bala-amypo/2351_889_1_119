package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class RiskAnalysisServiceImpl {

    private final UserPortfolioService portfolioService;

    public RiskAnalysisServiceImpl(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    public void analyzeRisk(Long portfolioId) {
        UserPortfolio portfolio = portfolioService.getPortfolioById(portfolioId);

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        System.out.println("Analyzing risk for " + portfolio.getPortfolioName() + " at " + timestamp);
    }
}
