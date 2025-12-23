package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_portfolios")
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String portfolioName;

    private LocalDateTime createdAt;

    // ✅ NO-ARGS CONSTRUCTOR
    public UserPortfolio() {}

    // ✅ ALL-ARGS CONSTRUCTOR
    public UserPortfolio(Long id, Long userId, String portfolioName, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
    }

    // ✅ GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
