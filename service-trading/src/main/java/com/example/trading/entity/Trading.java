package com.example.trading.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trading")
public class Trading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradingId;
    private String stockSymbol;
    private int quantity;
    private BigDecimal price;
    private LocalDateTime tradeTime;
    private String tradeType; // "BUY" or "SELL"

    public Trading(String stockSymbol, int quantity, BigDecimal price, String tradeType) {
        this.tradingId = UUID.randomUUID().toString();
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.tradeTime = LocalDateTime.now();
        this.tradeType = tradeType;
    }
}
