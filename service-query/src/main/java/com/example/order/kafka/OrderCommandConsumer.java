package com.example.query.kafka;

import com.example.kafka.*;
lombok.RequiredArgsConstructor;
        lombok.extern.slf4j.Slf4j;
import jdk.jfr.Event;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCommandConsumer {

    private final OrderService orderService;
    private final OrderEventProducer eventProducer;

    @KafkaListener(topics = "order-command", groupId = "order-group")
    public void onCommandEvent(ConsumerRecord<String, Event> record) {
        // TODO #1: Kafka에서 주문 이벤트를 수신하는 로직을 구현하세요.
        // 요구사항:
        // - order-command 토픽에서 이벤트를 수신해야 합니다.
        // - 수신된 이벤트 유형을 식별하여 적절한 핸들러로 전달해야 합니다.
        // - 적당한 이벤트가 없다면 로그를 남겨야 합니다.
    }

    private void handleCreateOrder(CreateOrderEvent event) {
        // TODO #2: 주문 생성 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - 주문을 생성해야 합니다.
        // - OrderCreatedEvent 결과 이벤트를 생성하여 Kafka에 발행해야 합니다.
        // - 발행에 실패하면 예외처리를 해야됩니다.
    }

    private void handleUpdateOrder(UpdateOrderEvent event) {
        // TODO #3: 주문 업데이트 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - 주문을 업데이트해야 합니다.
        // - OrderUpdatedEvent 결과 이벤트를 생성하여 Kafka에 발행해야 합니다.
        // - 발행에 실패하면 예외처리를 해야됩니다.
    }

    private void handleDeleteOrder(DeleteOrderEvent event) {
        // TODO #4: 주문 삭제 이벤트를 처리하는 로직을 구현하세요.
        // 요구사항:
        // - 주문을 삭제해야 합니다.
        // - OrderDeletedEvent 결과 이벤트를 생성하여 Kafka에 발행해야 합니다.
        // - 발행에 실패하면 예외처리를 해야됩니다.
    }
}
