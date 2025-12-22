package com.example.demo.service.impl;

import com.example.demo.model.Portfolio;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.PortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepo;
    private final PortfolioRepository portfolioRepo;
    private final StockRepository stockRepo;

    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository holdingRepo,
            PortfolioRepository portfolioRepo,
            StockRepository stockRepo) {
        this.holdingRepo = holdingRepo;
        this.portfolioRepo = portfolioRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {

        Portfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        Stock stock = stockRepo.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        holding.setPortfolio(portfolio);
        holding.setStock(stock);

        return holdingRepo.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepo.findByPortfolioId(portfolioId);
    }

    @Override
    public PortfolioHolding getHoldingById(Long holdingId) {
        return holdingRepo.findById(holdingId)
                .orElseThrow(() -> new RuntimeException("Holding not found"));
    }

    @Override
    public PortfolioHolding updateHolding(Long holdingId, PortfolioHolding holding) {

        PortfolioHolding existing = getHoldingById(holdingId);

        existing.setQuantity(holding.getQuantity());
        existing.setBuyPrice(holding.getBuyPrice());

        return holdingRepo.save(existing);
    }

    @Override
    public void deleteHolding(Long holdingId) {
        holdingRepo.deleteById(holdingId);
    }
}
