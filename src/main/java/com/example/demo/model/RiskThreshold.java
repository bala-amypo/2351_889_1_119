package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_threshold")
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double value;

    public RiskThreshold() {}

    public RiskThreshold(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
}
