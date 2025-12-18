package com.example.demo.model;
import jakarta.persistence.*;
public class RiskThreshold{
    @Id
    private Long id;
    private String thresholdName;
    private Decimal marketValue;
   
   private boolean active
}