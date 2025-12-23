package com.example.demo.model;

import java.math.BigDecimal;

public class RiskAnalysisResult {
    private boolean highRisk;
    private BigDecimal totalMarketValue;

    public RiskAnalysisResult() {}

    public RiskAnalysisResult(boolean highRisk, BigDecimal totalMarketValue) {
        this.highRisk = highRisk;
        this.totalMarketValue = totalMarketValue;
    }

    public boolean isHighRisk() { return highRisk; }
    public void setHighRisk(boolean highRisk) { this.highRisk = highRisk; }

    public BigDecimal getTotalMarketValue() { return totalMarketValue; }
    public void setTotalMarketValue(BigDecimal totalMarketValue) { this.totalMarketValue = totalMarketValue; }
}
