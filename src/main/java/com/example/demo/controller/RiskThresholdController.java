package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    @PostMapping
    public RiskThreshold create(@RequestBody RiskThreshold threshold) {
        return riskThresholdService.createThreshold(threshold);
    }

    @GetMapping("/{id}")
    public RiskThreshold getById(@PathVariable Long id) {
        return riskThresholdService.getThresholdById(id);
    }

    @GetMapping
    public List<RiskThreshold> getAll() {
        return riskThresholdService.getAllThresholds();
    }

    @GetMapping("/active")
    public RiskThreshold getActive() {
        return riskThresholdService.getActiveThreshold();
    }
}
