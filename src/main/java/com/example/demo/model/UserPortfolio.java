package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String portfolioName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active = true;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        active = true;
    }
}
