package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_analysis_result")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resultDescription;

    private Double riskScore;

    public RiskAnalysisResult() {}

    public RiskAnalysisResult(String resultDescription, Double riskScore) {
        this.resultDescription = resultDescription;
        this.riskScore = riskScore;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getResultDescription() { return resultDescription; }
    public void setResultDescription(String resultDescription) { this.resultDescription = resultDescription; }

    public Double getRiskScore() { return riskScore; }
    public void setRiskScore(Double riskScore) { this.riskScore = riskScore; }
}
