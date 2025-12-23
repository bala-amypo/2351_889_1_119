package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = stockRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(stock.getName());
        existing.setPrice(stock.getPrice());
        existing.setActive(stock.isActive());
        return stockRepository.save(existing);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            stock.setActive(false);
            stockRepository.save(stock);
        }
    }
}
