package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
public class PortfolioHolding{
    @Id
    private Long id;
    @Positive
    private Double quantity;
    @PositiveOrZero
    private Decimal marketValue;
    private localdate lastUpdated;
    public PortfolioHolding(Long id, Double quantity, Decimal marketValue) {
        this.id = id;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }
    public PortfolioHolding() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Decimal getMarketValue() {
        return marketValue;
    }
    public void setMarketValue(Decimal marketValue) {
        this.marketValue = marketValue;
    }

}