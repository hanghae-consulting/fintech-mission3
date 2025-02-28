package com.example.trading.kafka;

import com.example.kafka.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandConsumer {

    private final ProductService productService;
    private final ProductEventProducer eventProducer;

    @KafkaListener(topics = "product-command", groupId = "Product-group")
    public void onCommandEvent(ConsumerRecord<String, Event> record) {
        // TODO #1: Kafka에서 상품 이벤트를 수신하는 로직을 구현하세요.
        // 요구사항:
        // - product-command 토픽에서 이벤트를 수신해야 합니다.
        // - 수신된 이벤트 유형을 식별하여 적절한 핸들러로 전달해야 합니다.
        // - 적당한 이벤트가 없다면 로그를 남겨야 합니다.
    }

    private void handleCreateProduct(CreateProductEvent event) {
        // TODO #2: 상품 생성 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - 상품을 생성해야 합니다.
        // - ProductCreatedEvent 결과 이벤트를 생성하여 Kafka에 발행해야 합니다.
        // - 발행에 실패하면 예외처리를 해야됩니다.
    }

    private void handleUpdateProduct(UpdateProductEvent event) {
        // TODO #3: 상품 업데이트 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - 상품을 업데이트해야 합니다.
        // - ProductUpdatedEvent 결과 이벤트를 생성하여 Kafka에 발행해야 합니다.
        // - 발행에 실패하면 예외처리를 해야됩니다.
    }

    private void handleDeleteProduct(DeleteProductEvent event) {
        // TODO #4: 상품 삭제 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - 상품을 삭제해야 합니다.
        // - ProductDeletedEvent 결과 이벤트를 생성하여 Kafka에 발행해야 합니다.
        // - 발행에 실패하면 예외처리를 해야됩니다.
    }
}
