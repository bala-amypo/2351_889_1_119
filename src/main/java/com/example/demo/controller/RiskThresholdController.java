package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public RiskThreshold createThreshold(@RequestBody RiskThreshold threshold) {
        return thresholdService.createThreshold(threshold);
    }

    @PutMapping("/{id}")
    public RiskThreshold updateThreshold(@PathVariable Long id,
                                         @RequestBody RiskThreshold threshold) {
        return thresholdService.updateThreshold(id, threshold);
    }

    @GetMapping("/{id}")
    public RiskThreshold getThreshold(@PathVariable Long id) {
        return thresholdService.getThresholdById(id);
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
