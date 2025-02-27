package com.example.trading;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "stockClient", url = "http://localhost:8084")
public interface TradingFeignClient {
    // TODO #1: 재고를 생성하는 Feign 클라이언트 createStock 메서드를 구현하세요.
    // 요구사항:
    // - StockRequest를 받아 재고를 생성해야 합니다.
    // - 생성된 재고의 ID를 반환해야 합니다.

    // TODO #2: 특정 재고를 조회하는 Feign 클라이언트 getStock 메서드를 구현하세요.
    // 요구사항:
    // - stockId를 기반으로 재고를 조회해야 합니다.
    // - 조회된 재고 정보를 StockResponse로 반환해야 합니다.

    // TODO #3: 재고 정보를 업데이트하는 Feign 클라이언트 updateStocks 메서드를 구현하세요.
    // 요구사항:
    // - stockId와 새로운 재고 정보를 사용하여 재고를 업데이트해야 합니다.
    // - 업데이트 성공 여부를 반환해야 합니다.

    // TODO #4: 특정 수량만큼 재고를 감소시키는 Feign 클라이언트 decreaseStock 메서드를 구현하세요.
    // 요구사항:
    // - stockId를 기반으로 재고를 감소시켜야 합니다.
    // - 감소할 수량을 지정해야 합니다.
    // - 성공 여부를 반환해야 합니다.

    // TODO #5: 재고를 삭제하는 Feign 클라이언트 deleteStock 메서드를 구현하세요.
    // 요구사항:
    // - stockId를 기반으로 재고를 삭제해야 합니다.
    // - 삭제 성공 여부를 반환해야 합니다.
}
