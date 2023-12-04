package com.crea.backend.microservicespringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crea.backend.microservicespringboot.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> findAll();
    List<Product> findByNameLike(String name);
    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findByPriceLessThan(Integer price);
    Product findById(int id);
    Product deleteById(int id);
    Product existsById(int id);
    Product save(Product p);
}
