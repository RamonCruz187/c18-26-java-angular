package com.backend.gg.controller;

import com.backend.gg.dto.ProductDTO;
import com.backend.gg.entity.Product;
import com.backend.gg.enums.Coleccionable;
import com.backend.gg.mapper.ProductMapper;
import com.backend.gg.repository.ProductRepository;
import com.backend.gg.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;
    
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
    @GetMapping("categoria/{coleccionable}")
    public ResponseEntity getCategory(@PathVariable Coleccionable coleccionable){

        List<ProductDTO> productDTO =productMapper.convertToListDto(productRepository.getProductsByColeccionable(coleccionable)) ;

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