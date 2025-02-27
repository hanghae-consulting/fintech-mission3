package com.example.events;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventEntity {

    // TODO #1: 이벤트 데이터를 저장하는 엔티티 클래스를 구현하세요.
    // 요구사항:
    // - id: 이벤트의 고유 식별자 (자동 증가)
    // - eventType: 이벤트 유형 (예: "ProductCreatedEvent", "ProductUpdatedEvent" 등)
    // - payload: 이벤트 데이터 (JSON 또는 문자열)
    // - eventTime: 이벤트가 처리된 시간
    // - status: 이벤트 처리 상태 (예: "SUCCESS", "FAILED")
}