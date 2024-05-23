package com.backend.gg.service;

import com.backend.gg.entity.Order;
import com.backend.gg.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
