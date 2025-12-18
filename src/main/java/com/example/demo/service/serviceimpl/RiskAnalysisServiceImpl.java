package com.example.demo.service.serviceimpl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
