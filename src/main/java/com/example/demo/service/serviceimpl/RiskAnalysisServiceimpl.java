package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisResultServiceImpl implements RiskAnalysisResultService {

    private final RiskAnalysisResultRepository repository;

    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAnalysisResult createResult(RiskAnalysisResult result) {
        return repository.save(result);
    }

    @Override
    public RiskAnalysisResult updateResult(Long id, RiskAnalysisResult result) {
        result.setId(id);
        return repository.save(result);
    }

    @Override
    public RiskAnalysisResult getResultById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAllResults() {
        return repository.findAll();
    }

    @Override
    public void deleteResult(Long id) {
        repository.deleteById(id);
    }
}
