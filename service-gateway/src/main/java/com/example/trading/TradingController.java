package com.example.trading;

import com.example.stock.StockFeignClient;
import com.example.trading.dto.TradingRequest;
import com.example.trading.dto.TradingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/stock")
public class TradingController {

    private final StockFeignClient stockFeignClient;

    public TradingController(StockFeignClient stockFeignClient) {
        this.stockFeignClient = stockFeignClient;
    }

    @PostMapping
    public String createStock(@RequestBody TradingRequest request) {
        // TODO #1: 재고를 생성하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - StockFeignClient를 사용하여 재고를 생성해야 합니다.
        // - 생성된 재고의 ID를 반환해야 합니다.
    }

    @GetMapping("/{stockId}")
    public TradingResponse getStock(@PathVariable String stockId) {
        // TODO #2: 특정 재고를 조회하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - stockId를 기반으로 재고를 조회해야 합니다.
        // - 조회된 재고 정보를 반환해야 합니다.
    }

    @PutMapping("/{stockId}")
    public boolean updateStock(
            @PathVariable String stockId,
            @RequestBody TradingRequest request
    ) {
        // TODO #3: 재고 정보를 업데이트하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - stockId와 새로운 재고 정보를 사용하여 재고를 업데이트해야 합니다.
        // - 업데이트 성공 여부를 반환해야 합니다.
    }

    @PutMapping("/{stockId}/decrease/{quantity}")
    public boolean decreaseStock(
            @PathVariable String stockId,
            @PathVariable Long quantity
    ) {
        // TODO #4: 특정 수량만큼 재고를 감소시키는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - stockId를 기반으로 재고를 감소시켜야 합니다.
        // - 감소할 수량을 지정해야 합니다.
        // - 성공 여부를 반환해야 합니다.
    }

    @DeleteMapping("/{stockId}")
    public boolean deleteStore(@PathVariable String stockId) {
        // TODO #5: 재고를 삭제하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - stockId를 기반으로 재고를 삭제해야 합니다.
        // - 삭제 성공 여부를 반환해야 합니다.
    }
}
