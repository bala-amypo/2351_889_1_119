package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    // ===== BUSINESS METHOD =====
    public double getMarketValue() {
        return stock.getPrice() * quantity;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }
}
