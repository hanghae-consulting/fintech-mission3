package com.example.trading.controller;

import com.example.trading.dto.TradingRequest;
import com.example.trading.kafka.TradingEventProducer;
import com.example.trading.mapper.TradingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trading")
@RequiredArgsConstructor
public class TradingController {
    TradingEventProducer eventProducer;
    TradingMapper mapper;

    @PostMapping("/stock")
    public void tradeStock(@RequestBody TradingRequest req) {
        eventProducer.sendCommandEvent(mapper.toCreateEvent(req));
    }
}
