package com.example.query.service;

import com.example.cache.CachePublisher;
import com.example.kafka.CreateOrderEvent;
import com.example.kafka.UpdateOrderEvent;
import com.example.query.entity.Order;
import com.example.query.repository.OrderRepository;
import com.github.benmanes.caffeine.cache.Cache;
lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private static final String ORDER_KEY_PREFIX = "order:";

    private final Cache<String, Object> localCache;
    private final RedisTemplate<String, Object> redisTemplate;
    private final CachePublisher cachePublisher;
    private final OrderRepository orderRepository;


    public Order createOrder(CreateOrderEvent event) {
        // TODO #1: 주문을 생성하는 로직을 구현하세요.
        // 요구사항:
        // - 주문 정보를 DB에 저장해야 합니다.
        // - 저장된 주문을 Redis 및 로컬 캐시에 저장해야 합니다.
        // - 캐시키는 ORDER_KEY_PREFIX + 주문 UUID여야 합니다.
    }


    public Order getOrder(String orderId) {
        // TODO #2: 주문을 조회하는 로직을 구현하세요.
        // 요구사항:
        // - 로컬 캐시 -> Redis -> DB 순서로 조회해야 합니다.
        // - 각 캐시가 없을 때 캐시를 갱신해야 합니다.
        // - 조회된 주문 정보를 반환해야 합니다.
    }

    public Order updateOrder(UpdateOrderEvent event) {
        // TODO #3: 주문을 업데이트하는 로직을 구현하세요.
        // 요구사항:
        // - 주문 정보를 수정하고 캐시에 반영해야 합니다.
        // - 캐시 변경 사항을 다른 서버 인스턴스와 동기화해야 합니다.
    }

    public void deleteOrder(String orderId) {
        // TODO #4: 주문을 삭제하는 로직을 구현하세요.
        // 요구사항:
        // - 주문을 DB에서 삭제해야 합니다.
        // - 캐시에서도 삭제해야 하며, 다른 서버에도 삭제 이벤트를 전파해야 합니다.
    }
}
