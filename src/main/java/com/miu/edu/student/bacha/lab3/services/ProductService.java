package com.miu.edu.student.bacha.lab3.services;


import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product addProduct(Product product);
    Product updateProduct(int id, Product product);
    void deleteProduct(int id);
    List<Product> getProducts(Category category, double maxPrice);
    List<Product> getProduct(double minPrice);
    List<Product> getProductContaining(String keyword);
}
