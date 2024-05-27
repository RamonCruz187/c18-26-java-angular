package com.backend.gg.service;

import com.backend.gg.entity.OrderDetail;
import com.backend.gg.repository.OrderDetailRepository;
import com.backend.gg.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService{

    final OrderDetailRepository orderDetailRepository;
    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(OrderDetail orderDetail) {

    }

    @Override
    public Optional<OrderDetail> get(Long id) {
        return Optional.empty();
    }
}
