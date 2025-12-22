package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    // CREATE
    @PostMapping("/{portfolioId}/{stockId}")
    public PortfolioHolding addHolding(
            @PathVariable Long portfolioId,
            @PathVariable Long stockId,
            @RequestBody PortfolioHolding holding) {
        return holdingService.addHolding(portfolioId, stockId, holding);
    }

    // READ ALL
    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldings(@PathVariable Long portfolioId) {
        return holdingService.getHoldingsByPortfolio(portfolioId);
    }

    // READ BY ID
    @GetMapping("/{holdingId}")
    public PortfolioHolding getHoldingById(@PathVariable Long holdingId) {
        return holdingService.getHoldingById(holdingId);
    }

    // UPDATE
    @PutMapping("/{holdingId}")
    public PortfolioHolding updateHolding(
            @PathVariable Long holdingId,
            @RequestBody PortfolioHolding holding) {
        return holdingService.updateHolding(holdingId, holding);
    }

    // DELETE
    @DeleteMapping("/{holdingId}")
    public String deleteHolding(@PathVariable Long holdingId) {
        holdingService.deleteHolding(holdingId);
        return "Holding deleted successfully";
    }
}
