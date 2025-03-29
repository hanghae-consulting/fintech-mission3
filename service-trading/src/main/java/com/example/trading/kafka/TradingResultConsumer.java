package com.example.trading.kafka;

import com.example.events.EventEntity;
import com.example.events.EventRepository;
import com.example.kafka.*;
import com.example.utils.CustomMapper;
import com.example.utils.TimeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TradingResultConsumer {

    private final EventRepository eventRepository;
    private final TimeUtil timeUtil;

    @KafkaListener(topics = "trading-result", groupId = "Product-group")
    public void onResultEvent(ConsumerRecord<String, Event> record) {
        log.info("Received record: {}", record);
        Object event = record.value().getEvent();

        if (event instanceof TradingCreatedEvent) {
            handleCreatedTrading((TradingCreatedEvent) event);
        } else {
            log.warn("Unknown command event: {}", record);
        }
    }

    private void handleCreatedTrading(TradingCreatedEvent event) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            log.info("[ResultConsumer] TradingCreatedEvent: {}", event);
            eventRepository.save(new EventEntity(
                    event.getId(),
                    event.getClass().getName(),
                    event.toString(),
                    timeUtil.getCurrentTime(),
                    "SUCCESS"
            ));
        } catch (Exception e) {
            log.error("[ResultConsumer] Error in handleCreatedTrading: ", e);
            // 실패 시 별도 실패 이벤트 발행 가능
        }
    }
}
