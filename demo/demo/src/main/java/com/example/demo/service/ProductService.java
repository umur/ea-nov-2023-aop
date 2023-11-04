package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public interface ProductService {
     ArrayList<ProductDto> getProductsByMinPrice(double minPrice) ;

     ArrayList<ProductDto> getProductsByKeyword (String keyWord);

     ArrayList<ProductDto> getProductsByCategoryAndMaxPrice(CategoryDto category, double maxPrice);

     public ArrayList<ProductDto> getAllProducts();

     public ProductDto getProductById(long id);
     public Product createProduct(Product product);

    public void updateProduct(long id, Product product);

     public void deleteProduct(long id);

}
