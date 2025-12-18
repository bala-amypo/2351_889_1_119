package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
public class RiskThreshold{
    @Id
    private Long id;
    @column(unique=true)
    private String thresholdName;
    @Size(min=0,max=100)
    private Double maxSingleStockPercentage;
    @Size(min=0,max=100)
    private Double maxSectorPercentage;
    private boolean active;
}