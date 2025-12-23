package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user_portfolios")
public class UserPortfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private String portfolioName;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private Timestamp updatedAt;
    
    @Column(nullable = false)
    private Boolean active;
    
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PortfolioHolding> holdings;
    
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RiskAnalysisResult> riskAnalysisResults;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (updatedAt == null) {
            updatedAt = new Timestamp(System.currentTimeMillis());
        }
        if (active == null) {
            active = true;
        }
    }
    
    public UserPortfolio() {
    }
    
    public UserPortfolio(User user, String portfolioName, LocalDateTime createdAt) {
        this.user = user;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.active = true;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getPortfolioName() {
        return portfolioName;
    }
    
    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public List<PortfolioHolding> getHoldings() {
        return holdings;
    }
    
    public void setHoldings(List<PortfolioHolding> holdings) {
        this.holdings = holdings;
    }
    
    public List<RiskAnalysisResult> getRiskAnalysisResults() {
        return riskAnalysisResults;
    }
    
    public void setRiskAnalysisResults(List<RiskAnalysisResult> riskAnalysisResults) {
        this.riskAnalysisResults = riskAnalysisResults;
    }
}
