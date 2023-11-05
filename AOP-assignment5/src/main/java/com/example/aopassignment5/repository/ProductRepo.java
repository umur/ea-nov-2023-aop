package com.example.aopassignment5.repository;


import com.example.aopassignment5.model.Category;
import com.example.aopassignment5.model.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product,Integer> {

    List<Product> findAllByPriceGreaterThan(double Price);
    List<Product> findAllByCategoryAndPriceLessThan(Category category, double price);
    List<Product> findAllByNameContains(String keyword);
}