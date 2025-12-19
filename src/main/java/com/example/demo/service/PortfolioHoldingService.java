package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PortfolioHolding;

public interface PortfolioHoldingService {

    PortfolioHolding save(PortfolioHolding holding);

    List<PortfolioHolding> getAllHoldings();

    List<PortfolioHolding> getByPortfolioId(Long portfolioId);
}
