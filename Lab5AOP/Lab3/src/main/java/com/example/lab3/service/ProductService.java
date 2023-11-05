package com.example.lab3.service;

import com.example.lab3.Entity.Category;
import com.example.lab3.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByMinPrice(double minPrice);

    List<Product> getProductsByKeyword(String keyWord);

    List<Product> getProductsByCategoryAndMaxPrice(Category category, double maxPrice);


    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product createProduct(Product product);
    Product updateProduct(int productId, Product updateProduct);
    boolean deleteProduct(int productId);

}
