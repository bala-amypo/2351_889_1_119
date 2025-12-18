import java.util.*;
package com.example.demo.service;
package com.example.demo.entity.Stockentity;

public interface StockService{
    Stockentity savedata(Stockentity st);
    Stockentity getidval(int id);
    List<Stockentity>getall();
    Stockentity update(int id,Stockentity st);
    void delete(int id);

}