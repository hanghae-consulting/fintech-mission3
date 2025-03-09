package com.example.trading.repository;

import com.example.trading.entity.Trading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradingRepository extends JpaRepository<Trading, Long> {
    List<Trading> findByStockSymbol(String stockSymbol);
}
