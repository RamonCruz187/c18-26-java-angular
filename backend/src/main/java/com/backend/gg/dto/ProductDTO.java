
package com.backend.gg.dto;

import com.backend.gg.enums.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
    
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
