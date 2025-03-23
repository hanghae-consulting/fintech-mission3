package com.example.trading.service;

import com.example.kafka.CreateTradingEvent;
import com.example.entity.Trading;
import com.example.repository.TradingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TradingService {
    private final TradingRepository tradeRepository;

    @Transactional
    public Trading createTrading(CreateTradingEvent event) {
        Trading trading = new Trading(
                event.getStockSymbol(),
                event.getQuantity(),
                event.getPrice(),
                event.getTradeType()
        );

        return tradeRepository.save(trading);
    }
}
