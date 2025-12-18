package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public UserPortfolio create(@RequestBody UserPortfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    public UserPortfolio getById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getByUser(@PathVariable Long userId) {
        return portfolioService.getPortfoliosByUser(userId);
    }
}
