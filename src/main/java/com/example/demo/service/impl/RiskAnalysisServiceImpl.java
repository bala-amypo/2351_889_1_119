// package com.example.demo.service.impl;

// import com.example.demo.model.PortfolioHolding;
// import com.example.demo.repository.PortfolioHoldingRepository;
// import com.example.demo.service.RiskAnalysisService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RiskAnalysisServiceImpl implements RiskAnalysisService {

//     private final PortfolioHoldingRepository holdingRepo;

//     public RiskAnalysisServiceImpl(PortfolioHoldingRepository holdingRepo) {
//         this.holdingRepo = holdingRepo;
//     }


//     @Override
//     RiskAnalysisResult analyzePortfolio(Long portfolioId) {
//         return holdingRepo.findById(portfolioId);
//     }

//     @Override
//     RiskAnalysisResult getAnalysisById(Long id) {
//         return holdingRepo.findById(id);
//     }

//     @Override
//     public Double calculateTotalMarketValue(Long portfolioId) {

//         List<PortfolioHolding> holdings =
//                 holdingRepo.findByPortfolioId(portfolioId);

//         return holdings.stream()
//                 .mapToDouble(PortfolioHolding::getMarketValue)
//                 .sum();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.RiskAnalysisResult;
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

    // ✅ 1. Analyze portfolio
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        List<PortfolioHolding> holdings =
                holdingRepo.findByPortfolioId(portfolioId);

        double totalMarketValue = holdings.stream()
                .mapToDouble(PortfolioHolding::getMarketValue)
                .sum();

        String riskLevel = calculateRiskLevel(totalMarketValue);

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolioId(portfolioId);
        result.setTotalMarketValue(totalMarketValue);
        result.setRiskLevel(riskLevel);

        return result;
    }

    // ✅ 2. Get analysis by id (dummy/simple version)
    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        // Normally this should come from RiskAnalysisRepository
        // For now, returning a placeholder
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setId(id);
        result.setRiskLevel("MEDIUM");
        result.setTotalMarketValue(0.0);
        return result;
    }

    // ✅ 3. Get all analyses for a portfolio
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        // Simple implementation: return current analysis as single-item list
        return List.of(analyzePortfolio(portfolioId));
    }

    // 🔹 Helper method
    private String calculateRiskLevel(double totalMarketValue) {
        if (totalMarketValue > 1_000_000) {
            return "HIGH";
        } else if (totalMarketValue > 500_000) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
