package com.backend.gg.dto;

import com.backend.gg.entity.OrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartDto implements Serializable {

    private List<OrderDetailDto> orderDetailDtos;
    private BigDecimal shippingCost;

}
