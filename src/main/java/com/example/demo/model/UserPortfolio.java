package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JsonIgnore
    // private User user;
    private Long userId;

    private String portfolioName;
    private LocalDateTime createdAt;
    private Boolean active;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    private List<PortfolioHolding> holdings;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    private List<RiskAnalysisResult> analyses;

    public UserPortfolio() {}

    public UserPortfolio(Long userId, String portfolioName, LocalDateTime createdAt, Boolean active) {
        // this.user = user;
        this.userId = userId;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = userId;
    }

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

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

    public List<RiskAnalysisResult> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<RiskAnalysisResult> analyses) {
        this.analyses = analyses;
    }        
}
