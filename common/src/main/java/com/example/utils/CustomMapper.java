package com.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class CustomMapper {

    // 유일한 인스턴스를 생성
    private static final CustomMapper INSTANCE = new CustomMapper();

    private final ObjectMapper objectMapper;

    // private 생성자를 사용해 외부에서 인스턴스 생성을 막음
    private CustomMapper() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule()); // ✅ JavaTimeModule 등록
    }

    // 인스턴스 접근 메서드
    public static CustomMapper getInstance() {
        return INSTANCE;
    }

    // Object를 JSON 문자열로 변환하는 메서드
    public String convertToJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }
}
