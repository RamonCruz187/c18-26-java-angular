
package com.backend.gg.controller;

import com.backend.gg.dto.ProductDTO;
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
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/all")
    public ResponseEntity getAllProducts(){

        List<ProductDTO> productDTO = productService.getAllProducts();
        
        if(productDTO != null){
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        
        ProductDTO productDTO = productService.getProduct(id);
        
         if(productDTO != null){
                return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO){

        productService.createProduct(productDTO);
        
       return new ResponseEntity<>(productDTO,HttpStatus.OK);    
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
