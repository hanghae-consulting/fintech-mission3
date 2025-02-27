package com.example.query.kafka;

import com.example.kafka.*;
import com.example.query.entity.Order;
import com.example.query.service.OrderService;
import com.example.events.EventEntity;
import com.example.events.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
lombok.RequiredArgsConstructor;
        lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderResultConsumer {

    private final EventRepository eventRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "order-result", groupId = "order-group")
    public void onCommandEvent(ConsumerRecord<String, Event> record) {
        // TODO #1: Kafka에서 주문 결과 이벤트를 수신하는 로직을 구현하세요.
        // 요구사항:
        // - order-result 토픽에서 이벤트를 수신해야 합니다.
        // - 수신된 이벤트 유형을 식별하여 적절한 핸들러로 전달해야 합니다.
        // - 적당한 이벤트가 없다면 로그를 남겨야 합니다.
    }

    private void handleOrderCreated(OrderCreatedEvent evt) {
        // TODO #2: 주문 생성 결과 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - OrderCreatedEvent를 기반으로 이벤트 엔티티를 저장해야 합니다.
    }

    private void handleOrderUpdated(OrderUpdatedEvent evt) {
        // TODO #3: 주문 업데이트 결과 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - OrderUpdatedEvent를 기반으로 이벤트 엔티티를 저장해야 합니다.
    }

    private void handleOrderDeleted(OrderDeletedEvent evt) {
        // TODO #4: 주문 삭제 결과 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - OrderDeletedEvent를 기반으로 이벤트 엔티티를 저장해야 합니다.
    }
}
