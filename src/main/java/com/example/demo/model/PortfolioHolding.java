// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class PortfolioHolding {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "stock_id")
//     private Stock stock;

//     private int quantity;

//     @ManyToOne
//     @JoinColumn(name = "portfolio_id")
//     private UserPortfolio portfolio;

//     public double getMarketValue() {
//         return stock.getPrice() * quantity;
//     }

//     public Long getId() {
//         return id;
//     }

//     public Stock getStock() {
//         return stock;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public UserPortfolio getPortfolio() {
//         return portfolio;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setStock(Stock stock) {
//         this.stock = stock;
//     }

//     public void setQuantity(int quantity) {
//         this.quantity = quantity;
//     }

//     public void setPortfolio(UserPortfolio portfolio) {
//         this.portfolio = portfolio;
//     }
// }

package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;
    private BigDecimal marketValue;

    public PortfolioHolding() {}

    public PortfolioHolding(UserPortfolio portfolio, Stock stock,
                            Double quantity, BigDecimal marketValue) {
        this.portfolio = portfolio;
        this.stock = stock;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    
}
