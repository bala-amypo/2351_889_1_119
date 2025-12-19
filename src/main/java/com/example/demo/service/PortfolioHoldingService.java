public interface PortfolioHoldingService {
    PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding);
    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);
}
