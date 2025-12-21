package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // POST /
    @PostMapping
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public UserPortfolio updatePortfolio(@PathVariable Long id,
                                         @RequestBody UserPortfolio portfolio) {
        portfolio.setId(id);
        return portfolioService.createPortfolio(portfolio);
    }

    // GET /{id}
    @GetMapping("/{id}")
    public UserPortfolio getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    // GET /user/{userId}
    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getUserPortfolios(@PathVariable Long userId) {
        return portfolioService.getPortfoliosByUser(userId);
    }

    // PUT /{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public void deactivatePortfolio(@PathVariable Long id) {
        portfolioService.getPortfolioById(id); // placeholder if soft delete added later
    }
}
