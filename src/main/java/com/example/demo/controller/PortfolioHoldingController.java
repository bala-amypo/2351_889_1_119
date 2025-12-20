package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public PortfolioHolding add(@RequestBody PortfolioHolding holding) {
        return holdingService.addHolding(holding);
    }

    @GetMapping
    public List<PortfolioHolding> getAll() {
        return holdingService.getAllHoldings();
    }
}
