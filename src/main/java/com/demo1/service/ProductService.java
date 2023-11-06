package com.demo1.service;



import com.demo1.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(int id);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(int id, ProductDto productDto);

    void deleteProduct(int id);

    List<ProductDto> getProductsByMinPrice(int minPrice);

    List<ProductDto> getProductsByCategoryIdAndMaxPrice(int id, int maxPrice);

    List<ProductDto> getProductsByKeyword(String keyword);
}
