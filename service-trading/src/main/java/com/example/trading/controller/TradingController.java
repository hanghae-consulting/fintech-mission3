package com.example.trading.controller;

import com.example.trading.dto.TradingRequest;
import com.example.trading.kafka.TradingEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trading")
@RequiredArgsConstructor
public class TradingController {
    TradingEventProducer eventProducer;

    @PostMapping("/stock")
    public void tradeStock(@RequestBody TradingRequest req) {
        eventProducer.sendCommandEvent(req);
    }
}
