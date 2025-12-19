@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final StockRepository stockRepo;

    public PortfolioHoldingServiceImpl(
        PortfolioHoldingRepository holdingRepo,
        UserPortfolioRepository portfolioRepo,
        StockRepository stockRepo
    ) {
        this.holdingRepo = holdingRepo;
        this.portfolioRepo = portfolioRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        Stock stock = stockRepo.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        if (holding.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");

        if (holding.getMarketValue().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Market value must be zero or positive");

        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        return holdingRepo.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepo.findByPortfolioId(portfolioId);
    }
}
