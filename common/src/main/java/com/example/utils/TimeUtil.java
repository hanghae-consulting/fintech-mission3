package com.example.utils;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class TimeUtil {

    // 기본 시스템 타임존의 현재 시간 반환
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    // 지정한 타임존의 현재 시간 반환
    public LocalDateTime getCurrentTime(String zoneId) {
        return LocalDateTime.now(ZoneId.of(zoneId));
    }
}
