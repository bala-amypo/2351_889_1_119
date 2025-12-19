public interface RiskThresholdService {
    RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold);
    RiskThreshold getThresholdForPortfolio(Long portfolioId);
}
