package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;
    
    @Column(nullable = false)
    private Timestamp analysisDate;
    
    @Column(nullable = false)
    private Double highestStockPercentage;
    
    @Column
    private Double highestSectorPercentage;
    
    @Column(nullable = false)
    private Boolean isHighRisk;
    
    @Column(length = 500)
    private String notes;
    
    @PrePersist
    protected void onCreate() {
        if (analysisDate == null) {
            analysisDate = new Timestamp(System.currentTimeMillis());
        }
    }
    
    public RiskAnalysisResult() {
    }
    
    public RiskAnalysisResult(UserPortfolio portfolio, Timestamp analysisDate, Double highestStockPercentage, Boolean isHighRisk) {
        this.portfolio = portfolio;
        this.analysisDate = analysisDate;
        this.highestStockPercentage = highestStockPercentage;
        this.isHighRisk = isHighRisk;
        this.highestSectorPercentage = 0.0;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public UserPortfolio getPortfolio() {
        return portfolio;
    }
    
    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }
    
    public Timestamp getAnalysisDate() {
        return analysisDate;
    }
    
    public void setAnalysisDate(Timestamp analysisDate) {
        this.analysisDate = analysisDate;
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
    
    public Boolean getIsHighRisk() {
        return isHighRisk;
    }
    
    public void setIsHighRisk(Boolean isHighRisk) {
        this.isHighRisk = isHighRisk;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
}