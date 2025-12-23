package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String thresholdName;
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private Boolean active = true;
}
