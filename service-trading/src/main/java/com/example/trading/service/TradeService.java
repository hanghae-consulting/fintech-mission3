package com.example.trading.service;

import com.example.trading.entity.Trade;
import com.example.trading.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TradeService {
    private final TradeRepository tradeRepository;

    @Transactional
    public Trade buyStock(String symbol, int quantity, BigDecimal price) {
        Trade trade = new Trade(symbol, quantity, price, "BUY");
        return tradeRepository.save(trade);
    }

    @Transactional
    public Trade sellStock(String symbol, int quantity, BigDecimal price) {
        Trade trade = new Trade(symbol, quantity, price, "SELL");
        return tradeRepository.save(trade);
    }

    public List<Trade> getTradeHistory(String symbol) {
        return tradeRepository.findByStockSymbol(symbol);
    }
}
