package com.example.demo.controller;
import com.example.demo.model.RiskThresholdt;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    @PostMapping
    public RiskThreshold createThreshold(@RequestBody RiskThreshold threshold) {
        return riskThresholdService.createThreshold(threshold);
    }

    @PutMapping("/{id}")
    public RiskThreshold updateThreshold(@PathVariable Long id,
                                         @RequestBody RiskThreshold threshold) {
        return riskThresholdService.updateThreshold(id, threshold);
    }

    @GetMapping("/active")
    public RiskThreshold getActiveThreshold() {
        return riskThresholdService.getActiveThreshold();
    }

    @GetMapping("/{id}")
    public RiskThreshold getThresholdById(@PathVariable Long id) {
        return riskThresholdService.getThresholdById(id);
    }

    @GetMapping
    public List<RiskThreshold> getAllThresholds() {
        return riskThresholdService.getAllThresholds();
    }
}
