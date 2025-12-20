package com.example.demo.service.serviceimpl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioServiceImpl(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    @Override
    public UserPortfolio getPortfolio(Long id) {
        return repository.findById(id).orElse(null);
    }
}
