package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        stockRepository.findByTicker(stock.getTicker())
            .ifPresent(s -> { throw new RuntimeException("Duplicate ticker"); });
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = getStockById(id);
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        return stockRepository.save(existing);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock stock = getStockById(id);
        stock.setActive(false);
        stockRepository.save(stock);
    }
}
