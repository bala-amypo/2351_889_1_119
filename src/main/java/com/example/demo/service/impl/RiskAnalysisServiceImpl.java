package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final PortfolioHoldingRepository holdingRepo;

    public RiskAnalysisServiceImpl(PortfolioHoldingRepository holdingRepo) {
        this.holdingRepo = holdingRepo;
    }

    // @Override
    // public Double calculateTotalMarketValue(Long portfolioId) {

    //     List<PortfolioHolding> holdings =
    //             holdingRepo.findByPortfolioId(portfolioId);

    //     return holdings.stream()
    //             .mapToDouble(PortfolioHolding::getMarketValue)
    //             .sum();
    // }
}
