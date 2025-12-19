public interface RiskAnalysisService {
    RiskAnalysisResult analyzePortfolio(Long portfolioId);
    List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId);
}
