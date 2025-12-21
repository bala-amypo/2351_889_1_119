package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    // POST /
    @PostMapping("/{portfolioId}")
    public RiskThreshold createThreshold(@PathVariable Long portfolioId,
                                         @RequestBody RiskThreshold threshold) {
        return thresholdService.setThreshold(portfolioId, threshold);
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public RiskThreshold updateThreshold(@PathVariable Long id,
                                         @RequestBody RiskThreshold threshold) {
        threshold.setId(id);
        return threshold;
    }

    // GET /active
    @GetMapping("/active")
    public RiskThreshold getActiveThreshold() {
        throw new UnsupportedOperationException("Active threshold logic not defined");
    }

    // GET /{id}
    @GetMapping("/{id}")
    public RiskThreshold getThresholdById(@PathVariable Long id) {
        throw new UnsupportedOperationException("Fetch by ID if needed");
    }

    // GET /
    @GetMapping
    public List<RiskThreshold> listThresholds() {
        throw new UnsupportedOperationException("List thresholds if required");
    }
}
