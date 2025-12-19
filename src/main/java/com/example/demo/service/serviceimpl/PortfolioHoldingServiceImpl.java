package com.example.demo.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;

@Service
public class PortfolioHoldingServiceImpl
        implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding save(PortfolioHolding holding) {
        return repository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getAllHoldings() {
        return repository.findAll();
    }

    @Override
    public List<PortfolioHolding> getByPortfolioId(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
