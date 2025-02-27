package com.example.product.service;

import com.example.kafka.CreateProductEvent;
import com.example.kafka.UpdateProductEvent;
import com.example.cache.CachePublisher;
import com.example.product.dto.ProductMetricsDto;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final Cache<String, Object> localCache;
    private final RedisTemplate<String, Object> redisTemplate;
    private final CachePublisher cachePublisher;


    public Product createProduct(CreateProductEvent event) {
        // TODO #1: 상품을 생성하는 메서드를 구현하세요.
        // 요구사항:
        // - 상품을 DB에 저장해야 합니다.
        // - 저장된 상품을 캐시에 저장해야 합니다.
    }

    public Product getProduct(String productId) {
        // TODO #2: 상품을 조회하는 메서드를 구현하세요.
        // 요구사항:
        // - 로컬 캐시 → Redis → DB 순으로 조회해야 합니다.
        ㄴ
    }


    public Product updateProduct(UpdateProductEvent event) {
        // TODO #3: 상품을 업데이트하는 메서드를 구현하세요.
        // 요구사항:
        // - 상품 정보를 수정하고 캐시를 갱신해야 합니다.
    }


    public void deleteProduct(String productId) {
        // TODO #4: 상품을 삭제하는 메서드를 구현하세요.
        // 요구사항:
        // - 상품을 DB에서 삭제해야 합니다.
        // - 캐시를 무효화하고 삭제 이벤트를 발행해야 합니다.
    }
}
