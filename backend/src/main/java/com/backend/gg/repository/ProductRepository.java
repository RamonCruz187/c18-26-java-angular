package com.backend.gg.repository;

import com.backend.gg.entity.Product;
import com.backend.gg.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product getProductById(Long id);
    List<Product> getProductsByCategoria(Categoria categoria);

}
