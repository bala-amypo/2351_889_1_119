package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio_holdings")
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double buyPrice;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
