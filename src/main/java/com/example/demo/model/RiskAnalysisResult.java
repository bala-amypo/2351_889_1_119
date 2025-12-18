package com.example.demo.model;
import jakarta.persistence.*;
public class RiskAnalysisResult{
    @Id
    private Long id;
    @column(unique=true)
    private localdate analysis;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean isHighRisk;
    private String notes;

}