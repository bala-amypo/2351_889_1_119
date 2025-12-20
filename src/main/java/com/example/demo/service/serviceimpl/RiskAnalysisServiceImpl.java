package com.example.demo.service.serviceimpl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final UserPortfolioRepository portfolioRepository;

    public RiskAnalysisServiceImpl(UserPortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public double calculateTotalValue(UserPortfolio portfolio) {
        return portfolio.getHoldings()
                .stream()
                .mapToDouble(h -> h.getMarketValue())
                .sum();
    }

    @Override
    public String getAnalysesForPortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        double totalValue = calculateTotalValue(portfolio);

        return totalValue > 100000
                ? "HIGH RISK"
                : "LOW RISK";
    }
}
