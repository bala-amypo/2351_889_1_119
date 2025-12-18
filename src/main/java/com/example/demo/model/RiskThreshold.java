package com.example.demo.model;
import jakarta.persistence.*;
public class RiskThreshold{
    @Id
    private Long id;
    @column(unique=true)
    private String thresholdName;
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private boolean active;
}