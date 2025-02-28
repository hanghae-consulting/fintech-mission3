package com.example.order.service;

import com.example.order.entity.StockHolding;
import com.example.order.repository.StockHoldingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockQueryService {
    private final StockHoldingRepository stockHoldingRepository;

    public List<StockHolding> getStockHoldings(String stockSymbol) {
        return stockHoldingRepository.findByStockSymbol(stockSymbol);
    }
}
