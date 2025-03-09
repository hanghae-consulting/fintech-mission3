package com.example.trading.mapper;

import com.example.kafka.CreateTradingEvent;
import com.example.kafka.TradingCreatedEvent;
import com.example.trading.dto.TradingRequest;
import com.example.trading.entity.Trading;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TradingMapper {

    TradingMapper INSTANCE = Mappers.getMapper(TradingMapper.class);

    Trading toEntity(TradingRequest request);

    CreateTradingEvent toCreateEvent(TradingRequest request);

    TradingCreatedEvent toCreatedEvent(CreateTradingEvent event);

}