package com.example.aopassignment5.service;

import com.example.aopassignment5.model.Category;
import com.example.aopassignment5.model.Product;


import java.util.List;

public interface ProductService {
    Product findById(int id);
    Product saveProduct(Product product);
    Product updateProduct(int id,Product product);
    void deleteProduct(int id);
    List<Product> getProductsMoreThan(double minPrice);
    List<Product> findAllByCategoryAndPriceLessThan(Category category, double price);
    List<Product> getExistingContainsName(String keyword);

}