
package com.example.product.controller;

import com.example.kafka.*;
import com.example.product.dto.ProductDto;
import com.example.product.dto.ProductMetricsDto;
import com.example.product.entity.Product;
import com.example.product.kafka.ProductEventProducer;
import com.example.product.service.ProductService;
lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductEventProducer eventProducer;
    private final ProductService productService;

    @PostMapping
    public String createProduct(@RequestBody ProductDto dto) {
        // TODO #1: 상품을 생성하고 이벤트를 발행하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - UUID를 생성하여 상품 이벤트를 생성해야 합니다.
        // - CreateProductEvent를 생성하여 Kafka에 발행해야 합니다.
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        // TODO #2: 상품을 조회하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - productId를 기반으로 상품을 조회해야 합니다.
        // - 조회된 상품 정보를 반환해야 합니다.
    }

    @PutMapping("/{productId}")
    public boolean updateProduct(@PathVariable String productId,
                                 @RequestBody ProductDto dto) {
        // TODO #3: 상품을 업데이트하고 이벤트를 발행하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - productId와 ProductDto를 기반으로 UpdateProductEvent를 생성해야 합니다.
        // - Kafka에 이벤트를 발행해야 합니다.
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable String productId) {
        // TODO #4: 상품을 삭제하고 이벤트를 발행하는 API 엔드포인트를 구현하세요.
        // 요구사항:
        // - productId를 기반으로 DeleteProductEvent를 생성해야 합니다.
        // - Kafka에 이벤트를 발행해야 합니다.
    }
}
