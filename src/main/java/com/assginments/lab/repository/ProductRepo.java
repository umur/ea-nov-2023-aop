package com.assginments.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assginments.lab.entity.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

    // Find all products that cost more than minPrice.
    List<Product> findByPriceGreaterThan(double minPrice);

    // Find all products in cat category and cost less than maxPrice.
    List<Product> findByCategoryIdAndPriceLessThan(int categoryId, double minPrice);

    // Find all products that contain keyword in the name.
    List<Product> findByNameContaining(String keyword);

}
