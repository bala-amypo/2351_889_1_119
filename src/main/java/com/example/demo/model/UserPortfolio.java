package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<PortfolioHolding> holdings;

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<PortfolioHolding> getHoldings() {
        return holdings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHoldings(List<PortfolioHolding> holdings) {
        this.holdings = holdings;
    }
}
