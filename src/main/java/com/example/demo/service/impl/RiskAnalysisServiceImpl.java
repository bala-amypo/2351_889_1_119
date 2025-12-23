package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;

public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository resultRepo,
            UserPortfolioRepository portfolioRepo,
            PortfolioHoldingRepository holdingRepo,
            RiskThresholdRepository thresholdRepo) {

        this.resultRepo = resultRepo;
        this.portfolioRepo = portfolioRepo;
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        RiskThreshold threshold = thresholdRepo.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("Not found"));

        List<PortfolioHolding> holdings =
                holdingRepo.findByPortfolioId(portfolioId);

        double totalValue = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().doubleValue())
                .sum();

        double highestStockPct = 0;
        Map<String, Double> sectorMap = new HashMap<>();

        for (PortfolioHolding h : holdings) {
            double pct = (h.getMarketValue().doubleValue() / totalValue) * 100;
            highestStockPct = Math.max(highestStockPct, pct);

            String sector = h.getStock().getSector();
            sectorMap.put(sector, sectorMap.getOrDefault(sector, 0.0) + pct);
        }

        double highestSectorPct = sectorMap.values().stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0);

        boolean highRisk =
                highestStockPct > threshold.getMaxSingleStockPercentage()
             || highestSectorPct > threshold.getMaxSectorPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighestStockPercentage(highestStockPct);
        result.setHighestSectorPercentage(highestSectorPct);
        result.setIsHighRisk(highRisk);
        result.setNotes(highRisk ? "High risk detected" : "Within limits");

        return resultRepo.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepo.findByPortfolioId(portfolioId);
    }
}
