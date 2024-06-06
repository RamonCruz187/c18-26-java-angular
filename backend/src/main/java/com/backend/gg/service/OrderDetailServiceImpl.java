package com.backend.gg.service;

import com.backend.gg.dto.CartDto;
import com.backend.gg.dto.OrderDetailDto;
import com.backend.gg.entity.Order;
import com.backend.gg.entity.OrderDetail;
import com.backend.gg.entity.Product;
import com.backend.gg.enums.Status;
import com.backend.gg.repository.OrderDetailRepository;
import com.backend.gg.repository.ProductRepository;
import com.backend.gg.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService{

    final OrderDetailRepository orderDetailRepository;
    final OrderService orderService;
    final ProductRepository productRepository;
    final UserRepository userRepository;

    @Transactional
    public Order processNewCart(CartDto cartDto, Long id){

        Order order = new Order();
        List<OrderDetailDto> orderDetail = cartDto.getOrderDetailDtos();
        List<OrderDetail> ordersDetail = orderDetail.stream().map(orderDetailDto -> {

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(productRepository.getProductById(orderDetailDto.getProduct_id()));
            detail.setQuantity(orderDetailDto.getQuantity());
            detail.setUnitPrice(orderDetailDto.getUnitPrice());

            //se modifica el stock de cada order-detail
            Product product = productRepository.getProductById(orderDetailDto.getProduct_id());
            int stock = productRepository.getProductById(orderDetailDto.getProduct_id()).getStock();
            int quantity = detail.getQuantity();
            product.setStock(stock - quantity);
            productRepository.save(product);

            detail.setSubtotal(BigDecimal.valueOf(orderDetailDto.getUnitPrice() * orderDetailDto.getQuantity()));
            return detail;

        }).toList();
        BigDecimal total = ordersDetail.stream().map(OrderDetail::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(cartDto.getShippingCost().add(total));
        order.setStatus(Status.COMPLETED);
        order.setUser(userRepository.getUserById(id));
        order.setDetails(ordersDetail);

        orderService.save(order);
        orderDetailRepository.saveAll(ordersDetail);
        return order;
    }

    @Override
    public boolean stockControl(CartDto cartDto) {
        List<OrderDetailDto> orderDetailDtoList = cartDto.getOrderDetailDtos();

        for (OrderDetailDto orderDetailDto : orderDetailDtoList){
            Product product = productRepository.getProductById(orderDetailDto.getProduct_id());

            if (product.getStock()< orderDetailDto.getQuantity()){
                return false;
            }
        }

        return true;
    }

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