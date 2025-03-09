package com.example.repository;

import com.example.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradingRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByStockSymbol(String stockSymbol);
}
