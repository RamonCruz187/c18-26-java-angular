package com.backend.gg.service;

import com.backend.gg.entity.Order;

import java.util.Optional;

public interface OrderService {
    Order save(Order order);
    Optional<Order> get(Long id);
    void update(Order order);
    void delete(Long id);

}
