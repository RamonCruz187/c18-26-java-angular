package com.backend.gg.controller;

import com.backend.gg.entity.Product;
import com.backend.gg.repository.ProductRepository;
import com.backend.gg.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/newProduct")
    public String newProduct(@RequestBody Product product){
        productService.guardar(product);
        return "producto creado";

    }
}
