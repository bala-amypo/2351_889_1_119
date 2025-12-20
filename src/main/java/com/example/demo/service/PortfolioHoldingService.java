package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;

import java.util.List;

public interface PortfolioHoldingService {

    PortfolioHolding addHolding(UserPortfolio portfolio, Stock stock, int quantity);

    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);
}
