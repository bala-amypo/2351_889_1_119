package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String portfolioName;

    private LocalDate startDate;
    private LocalDate endDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
