package com.example.lab3.repository;

import com.example.lab3.Entity.Category;
import com.example.lab3.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryAndPriceLessThan(Category category, double maxPrice);
    List<Product> findByNameContaining(String keyword);
}