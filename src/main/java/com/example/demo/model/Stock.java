package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    private boolean isActive;

    public Stock() {}

    public Stock(Long id, String symbol, boolean isActive) {
        this.id = id;
        this.symbol = symbol;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }
}
