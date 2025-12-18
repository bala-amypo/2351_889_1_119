package com.example.demo.model;
import jakarta.persistence.*;
public class PortfolioHolding{
    @Id
    private Long id;
    private Double quantity;
    private Decimal marketValue;
    private localdate lastUpdated;

}