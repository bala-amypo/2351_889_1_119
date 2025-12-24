package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    @PostMapping("/{portfolioId}/{stockId}")
    public PortfolioHolding addHolding(@PathVariable Long portfolioId,
                                       @PathVariable Long stockId,
                                       @RequestBody PortfolioHolding holding) {
        return holding;
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return List.of();
    }
}
