package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository analysisRepository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolioId(portfolioId);
        result.setRiskScore(50.0);
        result.setStatus("CALCULATED");
        return analysisRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return analysisRepository.findById(id).orElse(null);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}
