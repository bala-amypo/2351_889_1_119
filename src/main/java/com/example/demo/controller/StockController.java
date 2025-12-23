package com.example.demo.controller;

import com.example.demo.model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @GetMapping("/{symbol}")
    public ResponseEntity<Stock> getStock(@PathVariable String symbol) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/")
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("/")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(stock);
    }
}
