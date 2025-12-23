package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        return holdingRepository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = holdingRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setQuantity(holding.getQuantity());
        existing.setBuyPrice(holding.getBuyPrice());
        return holdingRepository.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id).orElse(null);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        holdingRepository.deleteById(id);
    }
}
