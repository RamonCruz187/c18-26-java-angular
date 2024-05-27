package com.backend.gg.service;

import com.backend.gg.entity.OrderDetail;

import java.util.Optional;

public interface OrderDetailService {

    void save (OrderDetail orderDetail);

    void delete(Long id);

    void update (OrderDetail orderDetail);

    Optional<OrderDetail> get(Long id);
}
