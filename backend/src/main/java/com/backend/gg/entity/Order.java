package com.backend.gg.entity;

import com.backend.gg.enums.Status;
import com.backend.gg.security.entity.User;

import java.util.Date;

public class Order {

    private Long id;
    private Date orderDate;
    private User user;
    private OrderDetail detail;
    private double total;
    private Status status;
}
