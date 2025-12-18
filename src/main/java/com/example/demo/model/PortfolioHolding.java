package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;

public class PortfolioHolding{
    @Id
    private Long id;
    @Positive
    private Double quantity;
    @PositiveOrZero
    private BigDecimal marketValue;
    private LocalDate lastUpdated;
    public PortfolioHolding(Long id, Double quantity, BigDecimal marketValue) {
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
    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

}