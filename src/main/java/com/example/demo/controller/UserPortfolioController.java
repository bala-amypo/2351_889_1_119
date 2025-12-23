package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    @Autowired
    private UserPortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @PostMapping
    public UserPortfolio createPortfolio(@RequestParam Long userId,
                                         @RequestParam String portfolioName) {
        UserPortfolio portfolio = new UserPortfolio();
        User user = userService.findById(userId);
        portfolio.setUser(user);            // fixed
        portfolio.setPortfolioName(portfolioName);
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    public UserPortfolio getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getUserPortfolios(@PathVariable Long userId) {
        return portfolioService.getPortfoliosByUser(userId);
    }
}
