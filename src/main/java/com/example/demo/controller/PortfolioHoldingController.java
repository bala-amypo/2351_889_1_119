package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public PortfolioHolding createHolding(@RequestBody PortfolioHolding holding) {
        return holdingService.addHolding(holding);  // Matches service interface
    }

    @GetMapping("/{id}")
    public PortfolioHolding getHoldingById(@PathVariable Long id) {
        return holdingService.getAllHoldings()
                             .stream()
                             .filter(h -> h.getId().equals(id))
                             .findFirst()
                             .orElse(null);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        // Example filter, assuming portfolioId field exists
        return holdingService.getAllHoldings()
                             .stream()
                             .filter(h -> h.getId().equals(portfolioId))
                             .toList();
    }
}
