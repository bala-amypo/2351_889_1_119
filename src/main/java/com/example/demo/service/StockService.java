import java.util.*;
package com.example.demo.service;
package com.example.demo.entity.Stock;

public interface StockService{
    Stock savedata(Stock st);
    Stock getidval(int id);
    List<Stock>getall();
    Stock update(int id,Stock st);
    void delete(int id);

}