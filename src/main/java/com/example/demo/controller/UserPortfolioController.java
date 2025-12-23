package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @PutMapping("/{id}")
    public UserPortfolio updatePortfolio(@PathVariable Long id,
                                         @RequestBody UserPortfolio portfolio) {
        return portfolioService.updatePortfolio(id, portfolio);
    }

    @GetMapping("/{id}")
    public UserPortfolio getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getUserPortfolios(@PathVariable Long userId) {
        return portfolioService.getPortfoliosByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void deactivatePortfolio(@PathVariable Long id) {
        portfolioService.deactivatePortfolio(id);
    }
}
