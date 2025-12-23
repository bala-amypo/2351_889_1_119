package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import com.example.demo.service.StockService;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    @Autowired
    private PortfolioHoldingRepository holdingRepository;

    @Autowired
    private UserPortfolioService portfolioService;

    @Autowired
    private StockService stockService;

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {
        UserPortfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        Stock stock = stockService.getStockById(stockId);

        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (holding.getMarketValue().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Market value cannot be negative");
        }

        holding.setPortfolio(portfolio);   // fixed
        holding.setStock(stock);           // fixed
        return holdingRepository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }
}
