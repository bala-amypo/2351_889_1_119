package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private LocalDateTime analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean isHighRisk;
    private String notes;
}
