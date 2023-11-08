package com.miu.edu.student.bacha.lab3.repositories;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Integer> {
    List<Product> findByCategoryAndPriceLessThan(Category category, double price);
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByNameContaining(String keyword);
}
