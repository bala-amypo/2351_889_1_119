package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.model.PortfolioHolding;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class UserPortfolioController {

    @GetMapping("/{userId}")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable Long userId) {
        // Mock implementation
        UserPortfolio portfolio = new UserPortfolio();
        portfolio.setUserId(userId);
        return ResponseEntity.ok(portfolio);
    }

    @PostMapping("/{userId}/holdings")
    public ResponseEntity<PortfolioHolding> addHolding(@PathVariable Long userId,
                                                       @RequestBody PortfolioHolding holding) {
        // Mock implementation: add holding to user portfolio
        return ResponseEntity.ok(holding);
    }

    @GetMapping("/{userId}/holdings")
    public ResponseEntity<List<PortfolioHolding>> getHoldings(@PathVariable Long userId) {
        // Mock implementation
        return ResponseEntity.ok(List.of());
    }
}
