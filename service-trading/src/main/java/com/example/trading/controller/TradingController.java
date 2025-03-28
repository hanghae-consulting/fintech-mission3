package com.example.trading.controller;

import com.example.kafka.CreateTradingEvent;
import com.example.trading.dto.TradingRequest;
import com.example.trading.kafka.TradingEventProducer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/trading")
@AllArgsConstructor
public class TradingController {
    TradingEventProducer eventProducer;

    @PostMapping("/stock")
    public void tradeStock(@RequestBody CreateTradingEvent event) {
        log.info("tradeStock event: {}", event);
        eventProducer.sendCommandEvent(event);
    }
}
