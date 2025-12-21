package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping("/{portfolioId}")
    public RiskThreshold createThreshold(@PathVariable Long portfolioId,
                                         @RequestBody RiskThreshold threshold) {
        return thresholdService.setThreshold(portfolioId, threshold);
    }

    @GetMapping("/{portfolioId}")
    public RiskThreshold getThresholdForPortfolio(@PathVariable Long portfolioId) {
        return thresholdService.getThresholdForPortfolio(portfolioId);
    }

    @GetMapping
    public List<RiskThreshold> getAllThresholds() {
        return thresholdService.getAllThresholds();
    }

    @GetMapping("/active")
    public RiskThreshold getActiveThreshold() {
        return thresholdService.getActiveThreshold();
    }
}
