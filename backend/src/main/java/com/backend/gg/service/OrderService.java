package com.backend.gg.service;

import com.backend.gg.entity.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {


    void save(Order order);
    Order get(Long id);
    List<Order> findOrdersByDate(LocalDate date);
    void update(Order order);
    void delete(Long id);

}
