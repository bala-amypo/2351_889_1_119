package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        portfolio.setCreatedAt(LocalDateTime.now());
        return portfolio;
    }
}
