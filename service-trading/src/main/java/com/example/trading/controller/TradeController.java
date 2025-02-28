package com.example.trading.controller;

import com.example.trading.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/trading")
@RequiredArgsConstructor
public class TradeController {
    private final TradeService tradeService;

    @PostMapping("/buy")
    public Trade buyStock(@RequestParam String symbol, @RequestParam int quantity, @RequestParam BigDecimal price) {
        return tradeService.buyStock(symbol, quantity, price);
    }
}
