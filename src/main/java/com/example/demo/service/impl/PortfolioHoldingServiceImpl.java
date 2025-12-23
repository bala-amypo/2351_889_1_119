package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;

public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final StockRepository stockRepo;

    public PortfolioHoldingServiceImpl(
        PortfolioHoldingRepository holdingRepo,
        UserPortfolioRepository portfolioRepo,
        StockRepository stockRepo) {

        this.holdingRepo = holdingRepo;
        this.portfolioRepo = portfolioRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() <= 0)
            throw new RuntimeException("Quantity must be > 0");
        return holdingRepo.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = getHoldingById(id);
        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        return holdingRepo.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepo.findByPortfolioId(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        holdingRepo.deleteById(id);
    }
}
