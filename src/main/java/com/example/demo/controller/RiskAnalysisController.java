package com.example.demo.controller;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisController {

    private final cService riskAnalysisService;

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(
            @PathVariable Long portfolioId) {
        return riskAnalysisService.analyzePortfolio(portfolioId);
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult getAnalysisById(@PathVariable Long id) {
        return riskAnalysisService.getAnalysisById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getAnalysesForPortfolio(
            @PathVariable Long portfolioId) {
        return riskAnalysisService.getAnalysesForPortfolio(portfolioId);
    }
}
