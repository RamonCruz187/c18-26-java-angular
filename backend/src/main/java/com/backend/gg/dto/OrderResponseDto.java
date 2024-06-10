package com.backend.gg.dto;

import com.backend.gg.entity.OrderDetail;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto implements Serializable {
    public Long id;
    public LocalDateTime orderDate;
    public BigDecimal total;
    public String status;
    public Long user_id;
    public List<OrderDetailDto> details;

}
