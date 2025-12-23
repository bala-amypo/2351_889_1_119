package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository portfolioRepository;

    public UserPortfolioServiceImpl(UserPortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = portfolioRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(portfolio.getName());
        existing.setActive(portfolio.isActive());
        return portfolioRepository.save(existing);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }

    @Override
    public void deactivatePortfolio(Long id) {
        UserPortfolio portfolio = portfolioRepository.findById(id).orElse(null);
        if (portfolio != null) {
            portfolio.setActive(false);
            portfolioRepository.save(portfolio);
        }
    }
}
