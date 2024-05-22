package com.backend.gg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name= "FK_OrderDetail_Product"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name= "FK_OrderDetail_Order"))
    private Order order;
}
