package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetName;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getAmount() {
        return amount;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }
}
