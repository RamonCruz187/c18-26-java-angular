package com.backend.gg.mapper;

import com.backend.gg.dto.OrderDetailDto;
import com.backend.gg.entity.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    public OrderDetailDto OrderDetailDtoFromOrderDetail(OrderDetail orderDetail){
        return OrderDetailDto.builder()
                .product_id(orderDetail.getProduct().getId())
                .quantity(orderDetail.getQuantity())
                .unitPrice(orderDetail.getUnitPrice())
                .build();
    }
}
