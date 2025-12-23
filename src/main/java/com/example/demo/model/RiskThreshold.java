package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_thresholds")
public class RiskThreshold {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;
    
    @Column(unique = true)
    private String thresholdName;
    
    @Column(nullable = false)
    private Double maxSingleStockPercentage;
    
    @Column
    private Double maxSectorPercentage;
    
    @Column(nullable = false)
    private Boolean active;
    
    public RiskThreshold() {
    }
    
    public RiskThreshold(UserPortfolio portfolio, Double maxSingleStockPercentage, Double maxOverallVolatility) {
        this.portfolio = portfolio;
        this.maxSingleStockPercentage = maxSingleStockPercentage;
        this.maxSectorPercentage = maxOverallVolatility;
        this.active = true;
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
    
    public String getThresholdName() {
        return thresholdName;
    }
    
    public void setThresholdName(String thresholdName) {
        this.thresholdName = thresholdName;
    }
    
    public Double getMaxSingleStockPercentage() {
        return maxSingleStockPercentage;
    }
    
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }
    
    public Double getMaxSectorPercentage() {
        return maxSectorPercentage;
    }
    
    public void setMaxSectorPercentage(Double maxSectorPercentage) {
        this.maxSectorPercentage = maxSectorPercentage;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
}
