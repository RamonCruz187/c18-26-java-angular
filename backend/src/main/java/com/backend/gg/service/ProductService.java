
package com.backend.gg.service;

import com.backend.gg.entity.Product;
import java.util.List;

public interface ProductService {
    
    public Product getProduct(Long id);
    
    public List<Product> getAllProducts();
    
    public void createProduct(Product product);
    
    public boolean deleteProduct(Long id);
}
