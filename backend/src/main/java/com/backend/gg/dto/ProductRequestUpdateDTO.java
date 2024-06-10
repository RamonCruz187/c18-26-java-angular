
package com.backend.gg.dto;

import com.backend.gg.enums.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestUpdateDTO {
    
    private Long id;
    private String name;
    private String description;
    private int stock;
    private BigDecimal price;
    private String image;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
