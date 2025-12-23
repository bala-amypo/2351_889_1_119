package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService riskAnalysisService;

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @PostMapping("/portfolio/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(@PathVariable Long portfolioId) {
        return riskAnalysisService.analyzePortfolio(portfolioId);
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult getAnalysis(@PathVariable Long id) {
        return riskAnalysisService.getAnalysisById(id);
    }

    @GetMapping("/portfolio/{portfolioId}/all")
    public List<RiskAnalysisResult> getPortfolioAnalyses(@PathVariable Long portfolioId) {
        return riskAnalysisService.getAnalysesForPortfolio(portfolioId);
    }
}
