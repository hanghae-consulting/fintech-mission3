package com.example.repository;

import com.example.entity.Trading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradingRepository extends JpaRepository<Trading, Long> {
    List<Trading> findByStockSymbol(String stockSymbol);
}
