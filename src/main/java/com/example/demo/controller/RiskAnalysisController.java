package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.RiskAnalysis;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/riskAnalysis")
public class RiskAnalysisController {

    private final RiskAnalysisService riskAnalysisService;  // Fixed type

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @GetMapping
    public List<RiskAnalysis> getAllAnalyses() {
        return riskAnalysisService.getAllAnalyses();
    }

    @PostMapping
    public RiskAnalysis createAnalysis(@RequestBody RiskAnalysis analysis) {
        return riskAnalysisService.createAnalysis(analysis);
    }
}
