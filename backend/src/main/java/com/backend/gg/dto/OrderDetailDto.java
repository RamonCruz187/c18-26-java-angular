package com.backend.gg.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    public Long product_id;
    public int quantity;
    public double unitPrice;

}
