package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    // POST /api/holdings/{portfolioId}/{stockId}
    @PostMapping("/{portfolioId}/{stockId}")
    public PortfolioHolding addHolding(@PathVariable Long portfolioId,
                                       @PathVariable Long stockId,
                                       @RequestBody PortfolioHolding holding) {
        return holdingService.addHolding(portfolioId, stockId, holding);
    }

    // GET /api/holdings/portfolio/{portfolioId}
    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return holdingService.getHoldingsByPortfolio(portfolioId);
    }
}
