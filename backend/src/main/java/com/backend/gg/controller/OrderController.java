package com.backend.gg.controller;

import com.backend.gg.dto.OrderResponseDto;
import com.backend.gg.entity.Order;
import com.backend.gg.mapper.OrderMapper;
import com.backend.gg.repository.OrderRepository;
import com.backend.gg.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    @GetMapping("/get/order/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        try {
            Order order = orderService.get(id);
            OrderResponseDto orderResponseDto= orderMapper.toOrderResponseDto(order);
            return ResponseEntity.ofNullable(orderResponseDto);
        }catch (Exception e){
            return new ResponseEntity<>("Error al encontrar orden", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/order-by-date")
    public List<OrderResponseDto> getOrdersByDate(@RequestParam("date")
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return orderMapper.toOrderResponseDtoList(orderService.findOrdersByDate(date));
    }


}
