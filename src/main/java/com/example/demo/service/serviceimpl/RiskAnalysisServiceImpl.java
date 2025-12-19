@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;
    private final RiskAnalysisResultRepository analysisRepo;
    private final UserPortfolioRepository portfolioRepo;

    public RiskAnalysisServiceImpl(
        PortfolioHoldingRepository holdingRepo,
        RiskThresholdRepository thresholdRepo,
        RiskAnalysisResultRepository analysisRepo,
        UserPortfolioRepository portfolioRepo
    ) {
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
        this.analysisRepo = analysisRepo;
        this.portfolioRepo = portfolioRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        List<PortfolioHolding> holdings = holdingRepo.findByPortfolioId(portfolioId);
        RiskThreshold threshold = thresholdRepo.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        BigDecimal total = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highest = holdings.stream()
                .mapToDouble(h ->
                        h.getMarketValue().doubleValue() / total.doubleValue() * 100)
                .max().orElse(0);

        boolean highRisk = highest > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighestStockPercentage(highest);
        result.setIsHighRisk(highRisk);

        return analysisRepo.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepo.findByPortfolioId(portfolioId);
    }
}
