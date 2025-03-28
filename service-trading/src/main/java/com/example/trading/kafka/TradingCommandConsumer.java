package com.example.trading.kafka;

import com.example.kafka.*;
import com.example.entity.Trading;
import com.example.trading.service.TradingService;
import com.example.utils.InstantConverter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TradingCommandConsumer {

    private final TradingService tradingService;
    TradingEventProducer eventProducer;

    @KafkaListener(topics = "trading-command", groupId = "trading-group")
    public void onCommandEvent(ConsumerRecord<String, Event> record) {
        log.info("Received record: {}", record);
        Object event = record.value().getEvent();
        if (event instanceof CreateTradingEvent) {
            handleCreateTrading((CreateTradingEvent) event);
        } else {
            log.warn("Unknown command event: {}", record);
        }
    }

    private void handleCreateTrading(CreateTradingEvent event) {
        try {
            log.info("[CommandConsumer] CreateTradingEvent: {}", event);
            Trading trading = tradingService.createTrading(event);
            TradingCreatedEvent createdEvent = new TradingCreatedEvent(
                    trading.getId(),
                    trading.getTradingId(),
                    trading.getStockSymbol(),
                    trading.getQuantity(),
                    trading.getPrice(),
                    InstantConverter.convertLocalDateTimeToInstant(trading.getTradeTime()),
                    trading.getTradeType()
            );
            eventProducer.sendResultEvent(createdEvent);
        } catch (Exception e) {
            log.error("[CommandConsumer] Error in handleCreateTrading: ", e);
            // 실패 시 별도 실패 이벤트 발행 가능
        }
    }
}
