package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/riskThreshold")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    @GetMapping
    public List<RiskThreshold> getAllThresholds() {
        return riskThresholdService.getAllThresholds();
    }

    @PostMapping
    public RiskThreshold createThreshold(@RequestBody RiskThreshold threshold) {
        return riskThresholdService.createThreshold(threshold);
    }

    @PutMapping("/{id}")
    public RiskThreshold updateThreshold(@PathVariable Long id, @RequestBody RiskThreshold threshold) {
        return riskThresholdService.updateThreshold(id, threshold); // Fixed method
    }
}
