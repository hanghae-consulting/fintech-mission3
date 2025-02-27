package com.example.common.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockOrderRequest {
    @NotBlank
    private String userId;

    @NotBlank
    private String stockSymbol;

    @Min(1)
    private int quantity;
}
