package com.backend.gg.service;

import com.backend.gg.entity.Product;
import com.backend.gg.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts(){

        return productRepo.findAll();
    }

    public Product getProduct(Long id){

        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void createProduct(Product product) {

        productRepo.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {

        Optional<Product> product = productRepo.findById(id);

        if (product.isPresent()) {
            productRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}