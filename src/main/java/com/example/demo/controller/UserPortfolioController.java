package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class UserPortfolioController {

    private final UserPortfolioService service;

    public UserPortfolioController(UserPortfolioService service) {
        this.service = service;
    }

    @PostMapping
    public UserPortfolio createPortfolio(@RequestParam Long userId,
                                         @RequestParam String name) {
        UserPortfolio portfolio = new UserPortfolio();
        portfolio.setUserId(userId);
        portfolio.setPortfolioName(name);
        return service.save(portfolio);
    }
}
