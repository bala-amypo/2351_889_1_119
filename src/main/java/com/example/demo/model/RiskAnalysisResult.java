package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
public class RiskAnalysisResult{
    @Id
    private Long id;
    @column(unique=true)
    private LocalDate analysis;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean isHighRisk;
    private String notes;
    public RiskAnalysisResult(LocalDate analysis, Double highestSectorPercentage, Double highestStockPercentage, Long id, boolean isHighRisk, String notes) {
        this.analysis = analysis;
        this.highestSectorPercentage = highestSectorPercentage;
        this.highestStockPercentage = highestStockPercentage;
        this.id = id;
        this.isHighRisk = isHighRisk;
        this.notes = notes;
    }

    public RiskAnalysisResult() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getAnalysis() {
        return analysis;
    }
    public void setAnalysis(LocalDate analysis) {
        this.analysis = analysis;
    }
    public Double getHighestStockPercentage() {
        return highestStockPercentage;
    }
    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }
    public Double getHighestSectorPercentage() {
        return highestSectorPercentage;
    }
    public void setHighestSectorPercentage(Double highestSectorPercentage) {
        this.highestSectorPercentage = highestSectorPercentage;
    }
    public boolean isHighRisk() {
        return isHighRisk;
    }
    public void setHighRisk(boolean isHighRisk) {
        this.isHighRisk = isHighRisk;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

}