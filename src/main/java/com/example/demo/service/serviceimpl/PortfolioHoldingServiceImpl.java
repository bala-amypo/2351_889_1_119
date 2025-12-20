package com.example.demo.service.serviceimpl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repo;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repo) {
        this.repo = repo;
    }

    @Override
    public PortfolioHolding addHolding(PortfolioHolding holding) {
        return repo.save(holding);
    }

    @Override
    public List<PortfolioHolding> getAllHoldings() {
        return repo.findAll();
    }
}
