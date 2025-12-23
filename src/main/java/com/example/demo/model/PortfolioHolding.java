package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;
    private BigDecimal marketValue;
    private LocalDateTime lastUpdated;
}
