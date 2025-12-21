package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PortfolioHolding;

public interface PortfolioHoldingService {

    PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding);

    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);
}
