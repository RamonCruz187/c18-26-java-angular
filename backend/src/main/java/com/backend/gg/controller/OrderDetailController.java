package com.backend.gg.controller;


import com.backend.gg.dto.CartDto;
import com.backend.gg.dto.OrderDetailDto;
import com.backend.gg.entity.Order;
import com.backend.gg.entity.OrderDetail;
import com.backend.gg.enums.Status;
import com.backend.gg.repository.OrderDetailRepository;
import com.backend.gg.repository.ProductRepository;
import com.backend.gg.repository.UserRepository;
import com.backend.gg.service.OrderDetailService;
import com.backend.gg.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderDetailController {

    final OrderService orderService;
    final OrderDetailService orderDetailService;
    final OrderDetailRepository orderDetailRepository;
    final ProductRepository productRepository;
    final UserRepository userRepository;
    final 

    @PostMapping("/cart/{id}")
    public ResponseEntity<?> newCart (@RequestBody @Valid CartDto cartDto, @PathVariable Long id){

        Order order = new Order();
        List<OrderDetailDto> orderDetail = cartDto.getOrderDetailDtos();
        List<OrderDetail> ordersDetail = orderDetail.stream().map(orderDetailDto -> {
        OrderDetail detail = new OrderDetail();
        detail.setOrder(order);
        detail.setProduct(productRepository.getProductById(orderDetailDto.getProduct_id()));
        detail.setQuantity(orderDetailDto.getQuantity());
        detail.setUnitPrice(orderDetailDto.getUnitPrice());
        detail.setSubtotal(BigDecimal.valueOf(orderDetailDto.getUnitPrice() * orderDetailDto.getQuantity()));
        return detail;

        }).toList();
        BigDecimal total = ordersDetail.stream().map(OrderDetail::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(total);
        order.setStatus(Status.COMPLETED);
        order.setUser(userRepository.getUserById(id));
        order.setDetails(ordersDetail);

        orderService.save(order);
        orderDetailRepository.saveAll(ordersDetail);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
