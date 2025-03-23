package com.example.trading.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingRequest {

    private Long id;
    private String tradingId;
    private String stockSymbol;
    private int quantity;
    private BigDecimal price;
    private LocalDateTime tradeTime;
    private String tradeType; // "BUY" or "SELL"
}
