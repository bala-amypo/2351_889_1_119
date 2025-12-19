package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/portfolio-holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public PortfolioHolding create(@RequestBody PortfolioHolding holding) {
        return service.save(holding);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getByPortfolio(
            @PathVariable Long portfolioId) {
        return service.getByPortfolioId(portfolioId);
    }
}
