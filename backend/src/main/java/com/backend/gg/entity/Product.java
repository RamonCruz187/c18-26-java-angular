package com.backend.gg.entity;

import com.backend.gg.enums.Coleccionable;
import com.backend.gg.enums.Juguete;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int stock;
    private BigDecimal price;
    private String image;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Coleccionable coleccionable;
    @Enumerated(EnumType.STRING)
    private Juguete juguete;
}
