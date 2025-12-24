package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    @PostMapping
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio) {
        return portfolio;
    }

    @GetMapping("/{id}")
    public UserPortfolio getPortfolio(@PathVariable Long id) {
        return new UserPortfolio();
    }
}
