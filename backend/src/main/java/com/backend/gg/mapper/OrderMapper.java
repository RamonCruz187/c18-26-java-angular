package com.backend.gg.mapper;

import com.backend.gg.dto.OrderDetailDto;
import com.backend.gg.dto.OrderResponseDto;
import com.backend.gg.entity.Order;
import com.backend.gg.entity.OrderDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;
    public OrderResponseDto toOrderResponseDto (Order order){
        return OrderResponseDto.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .total(order.getTotal())
                .status(order.getStatus().toString())
                .user_id(order.getUser().getId())
                .details(order.getDetails().stream().map(orderDetailMapper::OrderDetailDtoFromOrderDetail).collect(Collectors.toList()))

                .build();
    }

    public List<OrderResponseDto> toOrderResponseDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::toOrderResponseDto)
                .collect(Collectors.toList());
    }
}
