package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingService {

    PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding);

    PortfolioHolding getHoldingById(Long id); 

    PortfolioHolding updateHolding(Long id, PortfolioHolding holding); 

    void deleteHolding(Long id); 

    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);
}
