package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;


public class RiskThreshold{
    @Id
    private Long id;
    @Column(unique=true)
    private String thresholdName;
    @Size(min=0,max=100)
    private Double maxSingleStockPercentage;
    @Size(min=0,max=100)
    private Double maxSectorPercentage;
    private boolean active;
    public RiskThreshold(Long id, String thresholdName, Double maxSingleStockPercentage, Double maxSectorPercentage,
            boolean active) {
        this.id = id;
        this.thresholdName = thresholdName;
        this.maxSingleStockPercentage = maxSingleStockPercentage;
        this.maxSectorPercentage = maxSectorPercentage;
        this.active = active;
    }

    public RiskThreshold() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}