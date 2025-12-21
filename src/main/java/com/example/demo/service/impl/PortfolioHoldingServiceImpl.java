package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.PortfolioHoldingService;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;
    private final PortfolioHoldingRepository holdingRepository;

    public PortfolioHoldingServiceImpl(UserPortfolioRepository portfolioRepository,
                                       StockRepository stockRepository,
                                       PortfolioHoldingRepository holdingRepository) {
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
        this.holdingRepository = holdingRepository;
    }

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (holding.getMarketValue().signum() < 0) {
            throw new IllegalArgumentException("Market value must be non-negative");
        }

        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        return holdingRepository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = getHoldingById(id);

        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (holding.getMarketValue().signum() < 0) {
            throw new IllegalArgumentException("Market value must be non-negative");
        }

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        return holdingRepository.save(existing);
    }

    @Override
    public void deleteHolding(Long id) {
        PortfolioHolding holding = getHoldingById(id);
        holdingRepository.delete(holding);
    }
}
