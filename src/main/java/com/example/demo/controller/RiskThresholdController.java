package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-threshold")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping("/portfolio/{portfolioId}")
    public RiskThreshold setThreshold(
            @PathVariable Long portfolioId,
            @RequestBody RiskThreshold threshold) {
        return service.setThreshold(portfolioId, threshold);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
        return service.getThresholdForPortfolio(portfolioId);
    }
}
