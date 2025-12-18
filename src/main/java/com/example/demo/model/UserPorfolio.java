package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
public class UserPortfolio{
    @Id
    private Long id;
    private Long userId;
    private String portfolio;
    private boolean active;
    private LocalDate Timestamp;
    private LocalDate updatedAt;
    public UserPortfolio(Long id, Long userId, String portfolio, boolean active, localdate timestamp,
            localdate updatedAt) {
        this.id = id;
        this.userId = userId;
        this.portfolio = portfolio;
        this.active = active;
        Timestamp = timestamp;
        this.updatedAt = updatedAt;
    }

    public UserPortfolio() {
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public localdate getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(localdate Timestamp) {
        this.Timestamp = Timestamp;
    }

    public localdate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(localdate updatedAt) {
        this.updatedAt = updatedAt;
    }

}