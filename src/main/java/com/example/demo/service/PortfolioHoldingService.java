import java.util.*;
package com.example.demo.service;
package com.example.demo.model.PortfolioHolding;

public interface PortfolioHoldingService extends PortfolioHolding
{
    PortfolioHolding createHolding(PortfolioHolding holding);
    PortfolioHolding updateHolding(Long id,PortfolioHolding holding);
    PortfolioHolding getHoldingById(Long id);
    PortfolioHolding getHoldingsByPortfolio(Long portfoliold);
    void deleteHolding (Long id);


}