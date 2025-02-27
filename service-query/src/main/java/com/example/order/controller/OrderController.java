package com.example.query.controller;

import com.example.kafka.CreateOrderEvent;
import com.example.kafka.DeleteOrderEvent;
import com.example.kafka.UpdateOrderEvent;
import com.example.query.dto.OrderDto;
import com.example.query.entity.Order;
import com.example.query.kafka.OrderEventProducer;
import com.example.query.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderEventProducer eventProducer;
    private final OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody OrderDto dto) {
        // TODO #1: 주문을 생성하고 이벤트를 발행하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - UUID를 생성하여 주문 이벤트를 생성해야 합니다.
        // - CreateOrderEvent를 생성하여 Kafka에 발행하고 uuid를 반환해야 합니다.
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        // TODO #2: 주문을 조회하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - orderId를 기반으로 주문을 조회해야 합니다.
        // - 조회된 주문 정보를 반환해야 합니다.
    }

    @PutMapping("/{orderId}")
    public boolean updateOrder(@PathVariable String orderId,
                               @RequestBody OrderDto dto) {
        // TODO #3: 주문을 업데이트하고 이벤트를 발행하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - orderId와 OrderDto를 기반으로 UpdateOrderEvent를 생성해야 합니다.
        // - Kafka에 이벤트를 발행해야 합니다.
        );
    }

    @DeleteMapping("/{orderId}")
    public boolean deleteOrder(@PathVariable String orderId) {
        // TODO #4: 주문을 삭제하고 이벤트를 발행하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - orderId를 기반으로 DeleteOrderEvent를 생성해야 합니다.
        // - Kafka에 이벤트를 발행해야 합니다.
    }
}
