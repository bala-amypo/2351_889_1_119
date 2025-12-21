package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/analyze/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(@PathVariable Long portfolioId) {
        return analysisService.analyzePortfolio(portfolioId);
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult getAnalysisById(@PathVariable Long id) {
        return analysisService.getAnalysisById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getAnalysesByPortfolio(@PathVariable Long portfolioId) {
        return analysisService.getAnalysesForPortfolio(portfolioId);
    }
}
