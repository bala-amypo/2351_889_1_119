package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final UserPortfolioRepository portfolioRepo;
    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;
    private final RiskAnalysisResultRepository analysisRepo;

    public RiskAnalysisServiceImpl(
            UserPortfolioRepository portfolioRepo,
            PortfolioHoldingRepository holdingRepo,
            RiskThresholdRepository thresholdRepo,
            RiskAnalysisResultRepository analysisRepo) {
        this.portfolioRepo = portfolioRepo;
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
        this.analysisRepo = analysisRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        List<PortfolioHolding> holdings = holdingRepo.findByPortfolioId(portfolioId);
        RiskThreshold threshold = thresholdRepo.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        BigDecimal total = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highestPct = holdings.stream()
                .mapToDouble(h ->
                        h.getMarketValue().divide(total, 4, RoundingMode.HALF_UP)
                                .doubleValue() * 100)
                .max()
                .orElse(0);

        boolean isHighRisk = highestPct > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult(
                portfolio,
                LocalDateTime.now(),
                highestPct,
                isHighRisk
        );

        return analysisRepo.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepo.findByPortfolioId(portfolioId);
    }
}
