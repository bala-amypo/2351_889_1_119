package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    // POST /api/risk-analysis/{portfolioId}
    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(@PathVariable Long portfolioId) {
        return analysisService.analyzePortfolio(portfolioId);
    }

    // GET /api/risk-analysis/{portfolioId}
    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalyses(@PathVariable Long portfolioId) {
        return analysisService.getAnalysesForPortfolio(portfolioId);
    }
}
