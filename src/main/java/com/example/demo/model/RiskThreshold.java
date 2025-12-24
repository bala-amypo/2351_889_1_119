package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_threshold")
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;

    private Double maxRiskScore;

    // --- Constructors ---
    public RiskThreshold() {}

    public RiskThreshold(Long portfolioId, Double maxRiskScore) {
        this.portfolioId = portfolioId;
        this.maxRiskScore = maxRiskScore;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Double getMaxRiskScore() {
        return maxRiskScore;
    }

    public void setMaxRiskScore(Double maxRiskScore) {
        this.maxRiskScore = maxRiskScore;
    }
} 