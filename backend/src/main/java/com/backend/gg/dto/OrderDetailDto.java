package com.backend.gg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class OrderDetailDto {
    public Long product_id;
    public int quantity;
    public double unitPrice;

}
