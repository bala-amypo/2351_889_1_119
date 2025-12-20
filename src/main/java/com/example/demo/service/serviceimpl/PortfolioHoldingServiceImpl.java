package com.example.demo.service.serviceimpl;

import com.example.demo.model.*;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding addHolding(UserPortfolio portfolio, Stock stock, int quantity) {

        PortfolioHolding holding = new PortfolioHolding();
        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        holding.setQuantity(quantity);

        return repository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
