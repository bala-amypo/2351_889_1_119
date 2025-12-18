package com.example.demo.model;

import jakarta.persistence.*;  // For @Entity, @Id, etc.
import java.time.LocalDate;    // Correct import for LocalDate

@Entity
@Table(name = "user_portfolio")
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "portfolio_name", nullable = false)
    private String portfolioName;

    @Column(name = "start_date")
    private LocalDate startDate;   // Fixed type

    @Column(name = "end_date")
    private LocalDate endDate;     // Fixed type

    @Column(name = "active")
    private boolean active = true; // Optional field to track deactivation

    // Constructors
    public UserPortfolio() {}

    public UserPortfolio(String portfolioName, LocalDate startDate, LocalDate endDate) {
        this.portfolioName = portfolioName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Optional: convenience method to deactivate portfolio
    public void deactivate() {
        this.active = false;
    }
}
