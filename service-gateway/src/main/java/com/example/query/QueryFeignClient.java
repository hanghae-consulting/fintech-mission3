package com.example.query;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "orderClient", url = "http://localhost:8083")
public interface QueryFeignClient {

    // TODO #1: 주문을 생성하는 createOrder 메서드를 구현하세요.
    // 요구사항:
    // - 요청 데이터를 기반으로 주문을 생성해야 합니다.
    // - 생성된 주문의 ID를 반환해야 합니다.

    // TODO #2: 주문 정보를 조회하는 getOrder 메서드를 구현하세요.
    // 요구사항:
    // - 주문 ID를 기반으로 단일 주문을 조회해야 합니다.
    // - 조회된 주문 정보를 QueryResponse 객체로 반환해야 합니다.

    // TODO #3: 주문을 업데이트하는 updateOrders 메서드를 구현하세요.
    // 요구사항:
    // - 주문 ID와 새로운 주문 데이터를 기반으로 주문을 업데이트해야 합니다.
    // - 업데이트가 성공하면 true를 반환해야 합니다.

    // TODO #4: 주문을 삭제하는 deleteOrder 메서드를 구현하세요.
    // 요구사항:
    // - 주문 ID를 기반으로 주문을 삭제해야 합니다.
    // - 삭제가 성공하면 true를 반환해야 합니다.
}
