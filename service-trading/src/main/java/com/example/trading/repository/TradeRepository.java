package com.example.trading.repository;

import com.example.trading.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface     TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByStockSymbol(String stockSymbol);
}
