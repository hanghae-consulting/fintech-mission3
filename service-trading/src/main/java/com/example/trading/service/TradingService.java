package com.example.trading.service;

import com.example.kafka.CreateTradingEvent;
import com.example.trading.dto.TradingRequest;
import com.example.trading.entity.Trading;
import com.example.trading.mapper.TradingMapper;
import com.example.trading.repository.TradingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TradingService {
    private final TradingRepository tradeRepository;
    private final TradingMapper tradingMapper;

    @Transactional
    public Trading createTrading(CreateTradingEvent event) {
        return tradeRepository.save(tradingMapper.toEntity(event));
    }
}
