package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingService {

    PortfolioHolding addHolding(PortfolioHolding holding);

    PortfolioHolding getHoldingById(Long id);

    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);

    void deleteHolding(Long id);
}
