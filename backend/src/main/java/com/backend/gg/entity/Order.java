package com.backend.gg.entity;

import com.backend.gg.enums.Status;
import com.backend.gg.security.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn (name = "orden_detail_id")
    private OrderDetail detail;
    private double total;
    private Status status;
}
