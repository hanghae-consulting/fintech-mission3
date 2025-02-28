package com.example.order.controller;

import com.example.order.entity.StockHolding;
import com.example.order.service.StockQueryService;
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
}
