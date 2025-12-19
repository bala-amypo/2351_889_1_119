package com.example.demo.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue();
    }

    @Override
    public RiskThreshold save(RiskThreshold riskThreshold) {
        return repository.save(riskThreshold);
    }
}
