package com.backend.gg.repository;

import com.backend.gg.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
List<Order> findAllByOrderDateBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
