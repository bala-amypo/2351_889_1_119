package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPortfolio {

    private Long id;
    private Long userId;
    private String portfolioName;
    private LocalDateTime createdAt;
}
