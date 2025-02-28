package com.example.order.repository;

import com.example.order.entity.StockHolding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockHoldingRepository extends JpaRepository<StockHolding, Long> {
    List<StockHolding> findByStockSymbol(String stockSymbol);
}
