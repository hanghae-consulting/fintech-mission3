package com.example.query.repository;

import com.example.query.entity.StockHolding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockHoldingRepository extends JpaRepository<StockHolding, Long> {
    List<StockHolding> findByStockSymbol(String stockSymbol);
}
