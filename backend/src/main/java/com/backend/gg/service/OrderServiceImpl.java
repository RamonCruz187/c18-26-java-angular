package com.backend.gg.service;

import com.backend.gg.entity.Order;
import com.backend.gg.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order get(Long id) {

        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findOrdersByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return orderRepository.findAllByOrderDateBetween(startOfDay, endOfDay) ;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
