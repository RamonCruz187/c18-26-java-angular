package com.backend.gg.entity;

import com.backend.gg.enums.Category;

public class Product {

    private Long id;
    private String name;
    private String description;
    private int stock;
    private double price;
    private String image;
    private boolean active;
    private Category category;
}
