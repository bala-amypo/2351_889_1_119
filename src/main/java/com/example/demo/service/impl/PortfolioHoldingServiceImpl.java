package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository portfolioHoldingRepository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository portfolioHoldingRepository) {
        this.portfolioHoldingRepository = portfolioHoldingRepository;
    }

    @Override
    public PortfolioHolding saveHolding(PortfolioHolding holding) {
        return portfolioHoldingRepository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByUserId(Long userId) {
        return portfolioHoldingRepository.findByUserId(userId);
    }

    @Override
    public void deleteHolding(Long holdingId) {
        portfolioHoldingRepository.deleteById(holdingId);
    }
}
