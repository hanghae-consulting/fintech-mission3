package com.example.query.service;

import com.example.entity.Trading;
import com.example.query.entity.StockHolding;
import com.example.query.repository.StockHoldingRepository;
import com.example.repository.TradingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockQueryService {
    private final StockHoldingRepository stockHoldingRepository;
    private final TradingRepository tradingRepository;

    public List<StockHolding> getStockHoldings(String stockSymbol) {
        return stockHoldingRepository.findByStockSymbol(stockSymbol);
    }

    public List<Trading> getTradingHistory(String stockSymbol) {
        return tradingRepository.findByStockSymbol(stockSymbol);
    }
}
