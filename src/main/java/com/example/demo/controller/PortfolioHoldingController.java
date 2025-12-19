package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    // CREATE
    @PostMapping
    public PortfolioHolding addHolding(
            @RequestBody PortfolioHolding holding) {
        return holdingService.save(holding);
    }

    // READ ALL
    @GetMapping
    public List<PortfolioHolding> getAllHoldings() {
        return holdingService.getAllHoldings();
    }

    // READ BY PORTFOLIO ID
    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getByPortfolioId(
            @PathVariable Long portfolioId) {
        return holdingService.getByPortfolioId(portfolioId);
    }
}
