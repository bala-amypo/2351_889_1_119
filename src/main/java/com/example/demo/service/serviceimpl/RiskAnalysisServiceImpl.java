package com.example.demo.service.serviceimpl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Override
    public List<RiskAnalysisResult> analyzePortfolio(Long portfolioId) {
        // dummy implementation for now
        return new ArrayList<>();
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return new ArrayList<>();
    }
}
