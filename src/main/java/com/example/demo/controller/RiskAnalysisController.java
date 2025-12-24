package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult analyze(@PathVariable Long portfolioId) {
        return new RiskAnalysisResult();
    }

    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalyses(@PathVariable Long portfolioId) {
        return List.of();
    }
}
