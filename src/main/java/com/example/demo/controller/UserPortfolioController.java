package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/userPortfolio")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PutMapping("/{id}")
    public UserPortfolio updatePortfolio(@PathVariable Long id, @RequestBody UserPortfolio portfolio) {
        return portfolioService.updatePortfolio(id, portfolio); // Matches service
    }

    @DeleteMapping("/{id}")
    public void deactivatePortfolio(@PathVariable Long id) {
        portfolioService.deactivatePortfolio(id); // Matches service
    }
}
