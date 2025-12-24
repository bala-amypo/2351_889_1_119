package com.example.demo.model;

import java.sql.Timestamp;

public class RiskAnalysisResult {

    private Double highestStockPercentage;
    private Boolean isHighRisk;
    private Timestamp analysisDate;

    public Double getHighestStockPercentage() {
        return highestStockPercentage;
    }

    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Boolean isHighRisk() {
        return isHighRisk;
    }

    public void setHighRisk(Boolean highRisk) {
        isHighRisk = highRisk;
    }

    public Timestamp getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Timestamp analysisDate) {
        this.analysisDate = analysisDate;
    }
}
