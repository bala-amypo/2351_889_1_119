package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class UserPortfolioController {

    private final UserPortfolioService userPortfolioService;

    public UserPortfolioController(UserPortfolioService userPortfolioService) {
        this.userPortfolioService = userPortfolioService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserPortfolio> createPortfolio(
            @RequestParam Long userId,
            @RequestParam String portfolioName) {

        UserPortfolio portfolio = new UserPortfolio();
        portfolio.setUserId(userId);
        portfolio.setPortfolioName(portfolioName);

        UserPortfolio saved = userPortfolioService.createPortfolio(portfolio);
        return ResponseEntity.ok(saved);
    }
}
