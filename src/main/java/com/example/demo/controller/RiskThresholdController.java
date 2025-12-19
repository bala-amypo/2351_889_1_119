package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/risk-threshold")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @GetMapping("/active")
    public RiskThreshold getActive() {
        return service.getActiveThreshold();
    }

    @PostMapping
    public RiskThreshold save(@RequestBody RiskThreshold riskThreshold) {
        return service.save(riskThreshold);
    }
}
