package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingService {

    PortfolioHolding addHolding(PortfolioHolding holding);

    List<PortfolioHolding> getAllHoldings();
}
