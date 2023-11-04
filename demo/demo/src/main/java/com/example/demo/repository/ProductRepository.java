package com.example.demo.repository;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryAndPriceLessThan(CategoryDto category, double maxPrice);
    List<Product> findByNameContaining(String keyword);
}
