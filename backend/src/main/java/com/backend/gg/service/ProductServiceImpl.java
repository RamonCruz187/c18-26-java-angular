package com.backend.gg.service;

import com.backend.gg.dto.ProductDTO;
import com.backend.gg.dto.ProductRequestUpdateDTO;
import com.backend.gg.entity.Product;
import com.backend.gg.mapper.ProductMapper;
import com.backend.gg.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductMapper productMapper;
    
    @Override
    public List<ProductDTO> getAllProducts(){
        
       return productMapper.convertToListDto(productRepo.findAll());
    }
    
    @Override
    public ProductDTO getProduct(Long id){
        
        return productMapper.toProductDTO(productRepo.findById(id).orElse(null));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        
        Product product = productMapper.toProductSet(productDTO);
        
        product = productRepo.save(product);
        return productMapper.toProductDTO(product);
    }

    @Override
    public ProductRequestUpdateDTO update(Long id, ProductRequestUpdateDTO ProductUpdateDTO) {
        
        Optional<Product> optionalProduct = productRepo.findById(id);
        
        if (optionalProduct.isPresent()) {
        Product product = optionalProduct.get();
        
        BeanUtils.copyProperties(ProductUpdateDTO, product);// Actualiza las propiedades del producto
        Product updatedProduct = productRepo.save(product); // Guarda el producto actualizado
       
        ProductRequestUpdateDTO updatedDTO = new <Optional> ProductRequestUpdateDTO();
        BeanUtils.copyProperties(updatedProduct, updatedDTO);

        return updatedDTO;
        
        } else {
        return null;
        
        }

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