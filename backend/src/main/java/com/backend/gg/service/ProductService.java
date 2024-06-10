
package com.backend.gg.service;

import com.backend.gg.dto.ProductDTO;
import com.backend.gg.dto.ProductRequestUpdateDTO;
import com.backend.gg.entity.Product;
import com.backend.gg.enums.Categoria;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    
    public ProductDTO getProduct(Long id);
    
    public List<ProductDTO> getAllProducts();
    
    public List<ProductDTO> getCategory(Categoria categoria);
    
    public ProductDTO createProduct(ProductDTO productDTO);
    
    ProductRequestUpdateDTO update(Long id, ProductRequestUpdateDTO ProductUpdateDTO);
    
    public boolean deleteProduct(Long id);

}
