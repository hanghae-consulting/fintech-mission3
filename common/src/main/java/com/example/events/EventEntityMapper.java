package com.example.events;

import com.example.events.EventEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class EventEntityMapper {

    public static final EventEntityMapper INSTANCE = Mappers.getMapper(EventEntityMapper.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Mapping(target = "id", ignore = true) // ID는 자동 생성
    @Mapping(target = "eventType", expression = "java(getEventType(event))") // 이벤트 타입 자동 설정
    @Mapping(target = "payload", expression = "java(toJson(event))") // JSON 변환
    @Mapping(target = "eventTime", expression = "java(LocalDateTime.now())") // 현재 시간
    @Mapping(target = "status", constant = "SUCCESS") // 기본값 설정
    public abstract EventEntity toEventEntity(Object event);

    protected String getEventType(Object event) {
        return event.getClass().getSimpleName(); // 예: "TradingCreatedEvent"
    }

    protected String toJson(Object event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert event to JSON", e);
        }
    }
}
