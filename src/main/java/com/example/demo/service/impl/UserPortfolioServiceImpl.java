package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioServiceImpl(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPortfolio save(UserPortfolio portfolio) {
        portfolio.setCreatedAt(LocalDateTime.now());
        return repository.save(portfolio);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
    }
}
