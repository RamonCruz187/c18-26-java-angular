package com.backend.gg.service;

import com.backend.gg.dto.CartDto;
import com.backend.gg.entity.Order;
import com.backend.gg.entity.OrderDetail;

import java.util.Optional;

public interface OrderDetailService {

    public Order processNewCart(CartDto cartDto, Long id);
    void save (OrderDetail orderDetail);

    void delete(Long id);

    void update (OrderDetail orderDetail);

    Optional<OrderDetail> get(Long id);
}
