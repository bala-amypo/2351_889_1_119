package com.example.demo.service.serviceimpl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return repository.findAll();
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue();
    }
}
