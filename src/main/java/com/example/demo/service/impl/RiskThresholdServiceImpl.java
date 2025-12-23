package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = thresholdRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setMaxRisk(threshold.getMaxRisk());
        existing.setActive(threshold.isActive());
        return thresholdRepository.save(existing);
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return thresholdRepository.findByActiveTrue();
    }
}
