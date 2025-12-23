package com.example.demo.service;

import com.example.demo.model.UserPortfolio;

public interface UserPortfolioService {

    UserPortfolio save(UserPortfolio portfolio);

    UserPortfolio getPortfolioById(Long id);
}
