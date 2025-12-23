package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class UserPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PortfolioHolding> holdings;

    public UserPortfolio() {}

    public UserPortfolio(String userEmail, List<PortfolioHolding> holdings) {
        this.userEmail = userEmail;
        this.holdings = holdings;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<PortfolioHolding> getHoldings() { return holdings; }
    public void setHoldings(List<PortfolioHolding> holdings) { this.holdings = holdings; }
}
