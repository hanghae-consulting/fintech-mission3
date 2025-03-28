package com.example.query.controller;

import com.example.entity.Trading;
import com.example.query.entity.StockHolding;
import com.example.query.service.StockQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query")
@RequiredArgsConstructor
public class StockQueryController {
    private final StockQueryService stockQueryService;

    @GetMapping("/holdings")
    public List<StockHolding> getStockHoldings(@RequestParam String symbol) {
        return stockQueryService.getStockHoldings(symbol);
    }

    @GetMapping("/history")
    public List<Trading> getTradeHistory(@RequestParam String symbol) {
        return stockQueryService.getTradingHistory(symbol);
    }
}
