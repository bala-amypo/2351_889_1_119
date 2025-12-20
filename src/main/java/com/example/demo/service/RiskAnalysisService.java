package com.example.demo.service;

import com.example.demo.model.UserPortfolio;

public interface RiskAnalysisService {

    double calculateTotalValue(UserPortfolio portfolio);

    String getAnalysesForPortfolio(Long portfolioId);
}
