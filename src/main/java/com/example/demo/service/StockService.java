import java.util.*;
package com.example.demo.service;
package com.example.demo.model.Stock;

public interface StockService extends Stock
{
    Stock createStock(Stock stock);
    Stock updateStock(Long id,Stock stock);
    Stock getStockById(Long id);
    List <Stock> getAllStocks();
    void deactivateStock(Long id);


}