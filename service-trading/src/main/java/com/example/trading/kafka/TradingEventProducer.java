package com.example.trading.kafka;

import com.example.kafka.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TradingEventProducer {

    @Autowired
    private final KafkaTemplate<String, Event> kafkaTemplate;

    private static final String COMMAND_TOPIC = "trading-command";
    private static final String RESULT_TOPIC = "trading-result";

    public void sendCommandEvent(Object event) {
        kafkaTemplate.send(COMMAND_TOPIC, new Event(event.getClass().getName(), event));
    }

    public void sendResultEvent(Object event) {
        log.info(RESULT_TOPIC + ": " + event);
        kafkaTemplate.send(RESULT_TOPIC, new Event(event.getClass().getName(), event));
    }
}
