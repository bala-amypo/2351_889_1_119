package com.example.demo.service.serviceimpl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Override
    public double calculateTotalValue(UserPortfolio portfolio) {

        return portfolio.getHoldings()
                .stream()
                .mapToDouble(PortfolioHolding::getMarketValue)
                .sum();
    }
}
