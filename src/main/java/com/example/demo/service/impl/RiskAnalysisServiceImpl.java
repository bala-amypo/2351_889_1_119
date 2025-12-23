package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.PortfolioHoldingService;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Autowired
    private PortfolioHoldingService holdingService;

    @Autowired
    private UserPortfolioService portfolioService;

    @Autowired
    private RiskAnalysisResultRepository resultRepository;

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        List<PortfolioHolding> holdings = holdingService.getHoldingsByPortfolio(portfolioId);

        double totalMarketValue = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .mapToDouble(BigDecimal::doubleValue)     // fixed BigDecimal
                .sum();

        double highestPercentage = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().doubleValue() / totalMarketValue * 100)
                .max()
                .orElse(0.0);

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);                  // fixed
        result.setAnalysisDate(LocalDateTime.now());     // fixed
        result.setHighestStockPercentage(highestPercentage); // fixed
        result.setIsHighRisk(highestPercentage > 50);   // example threshold

        return resultRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepository.findByPortfolioId(portfolioId);
    }
}
