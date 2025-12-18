package com.example.demo.service.serviceimpl;

import org.springframework.stereotype.Service;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import java.util.List;
import java.util.ArrayList;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private List<PortfolioHolding> holdings = new ArrayList<>();

    @Override
    public PortfolioHolding addHolding(PortfolioHolding holding) {
        holdings.add(holding);
        return holding;
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        // Simplified example
        return holding;
    }

    @Override
    public List<PortfolioHolding> getAllHoldings() {
        return holdings;
    }

    @Override
    public void deleteHolding(Long id) {
        holdings.removeIf(h -> h.getId().equals(id));
    }
}
