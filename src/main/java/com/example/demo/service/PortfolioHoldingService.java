package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingService {

    PortfolioHolding saveHolding(PortfolioHolding holding);

    List<PortfolioHolding> getHoldingsByUserId(Long userId);

    void deleteHolding(Long holdingId);
}
