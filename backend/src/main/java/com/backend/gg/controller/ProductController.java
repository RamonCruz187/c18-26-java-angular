package com.backend.gg.controller;

import com.backend.gg.entity.Product;
import com.backend.gg.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> products = productService.getAllProducts();

        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){

        Product product = productService.getProduct(id);

        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        productService.createProduct(product);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){

        boolean removed = productService.deleteProduct(id);
        if(removed) {
            return new ResponseEntity<>("the product was deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("the product with that id does not exist ", HttpStatus.NOT_FOUND);
        }
    }
}