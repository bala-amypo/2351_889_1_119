package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;

    private Double threshold;

    public RiskThreshold() {}

    public Long getId() {
        return id;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
}
