package com.backend.gg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<Product> products;
    @OneToOne (mappedBy = "detail", cascade = CascadeType.ALL)
    private Order order;
}
