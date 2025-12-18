package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long portfolioId;
    private String analysisType;
    private Double riskScore;
    private Double volatility;
    private Double sharpeRatio;
    private String riskLevel;
    private LocalDateTime analysisDate;
    private boolean active = true;
    
    // Default constructor
    public RiskAnalysisResult() {}
    
    // Constructor with required fields
    public RiskAnalysisResult(Long portfolioId, String analysisType, Double riskScore) {
        this.portfolioId = portfolioId;
        this.analysisType = analysisType;
        this.riskScore = riskScore;
        this.analysisDate = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPortfolioId() { return portfolioId; }
    public void setPortfolioId(Long portfolioId) { this.portfolioId = portfolioId; }
    
    public String getAnalysisType() { return analysisType; }
    public void setAnalysisType(String analysisType) { this.analysisType = analysisType; }
    
    public Double getRiskScore() { return riskScore; }
    public void setRiskScore(Double riskScore) { this.riskScore = riskScore; }
    
    public Double getVolatility() { return volatility; }
    public void setVolatility(Double volatility) { this.volatility = volatility; }
    
    public Double getSharpeRatio() { return sharpeRatio; }
    public void setSharpeRatio(Double sharpeRatio) { this.sharpeRatio = sharpeRatio; }
    
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    
    public LocalDateTime getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(LocalDateTime analysisDate) { this.analysisDate = analysisDate; }
    
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
