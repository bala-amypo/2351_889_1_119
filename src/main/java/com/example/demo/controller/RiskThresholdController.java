package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    @PostMapping("/{portfolioId}")
    public RiskThreshold setThreshold(@PathVariable Long portfolioId,
                                      @RequestBody RiskThreshold threshold) {
        return threshold;
    }

    @GetMapping("/{portfolioId}")
    public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
        return new RiskThreshold();
    }
}
