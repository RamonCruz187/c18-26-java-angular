package com.backend.gg.service;

import com.backend.gg.entity.Product;
import com.backend.gg.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    @Override
    public void guardar(Product product) {
        productRepository.save(product);
    }
}
