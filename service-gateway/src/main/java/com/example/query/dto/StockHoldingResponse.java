package com.example.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class  StockHoldingResponse {
    private String stockSymbol;
    private int quantity;
}
