package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stockSymbol;
    private int quantity;
    private BigDecimal price;
    private LocalDateTime tradeTime;
    private String tradeType; // "BUY" or "SELL"

    public Trade(String stockSymbol, int quantity, BigDecimal price, String tradeType) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.tradeTime = LocalDateTime.now();
        this.tradeType = tradeType;
    }
}
