package com.example.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class InstantConverter {

    // 인스턴스화를 방지하기 위한 private 생성자
    private InstantConverter() {}

    /**
     * Instant 객체를 LocalDateTime으로 변환합니다.
     * 시스템 기본 타임존(ZoneId.systemDefault())을 사용합니다.
     *
     * @param instant 변환할 Instant 객체
     * @return 변환된 LocalDateTime, instant가 null이면 null 반환
     */
    public static LocalDateTime convertInstantToLocalDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * LocalDateTime 객체를 Instant로 변환합니다.
     * 시스템 기본 타임존(ZoneId.systemDefault())을 사용합니다.
     *
     * @param localDateTime 변환할 LocalDateTime 객체
     * @return 변환된 Instant, localDateTime이 null이면 null 반환
     */
    public static Instant convertLocalDateTimeToInstant(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}
