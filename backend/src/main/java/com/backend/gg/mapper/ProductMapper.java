
package com.backend.gg.mapper;

import com.backend.gg.dto.ProductDTO;
import com.backend.gg.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    
    public Product toProductSet(ProductDTO productDTO) {
    return Product.builder()
            .name(productDTO.getName())
            .description(productDTO.getDescription())
            .stock(productDTO.getStock())
            .price(productDTO.getPrice())
            .image(productDTO.getImage())
            .coleccionable(productDTO.getColeccionable())
            .juguete(productDTO.getJuguete())
            .build();
}
    
    public ProductDTO toProductDTO(Product product) {
    return ProductDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .stock(product.getStock())
            .price(product.getPrice())
            .image(product.getImage())
            .coleccionable(product.getColeccionable())
            .juguete(product.getJuguete())
            .build();
}
    
    
    public List<ProductDTO> convertToListDto(List<Product> products){

        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<>();
        for ( Product c : products ) {
            list.add(toProductDTO(c));
        }

        return list;
    }
}
