package com.miu.lab4aop.service;

import com.miu.lab4aop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    void deleteById(Integer id);

    ProductDto findById(Integer id);

    List<ProductDto> findAll();

    ProductDto update(ProductDto productDto, Integer id);
    List<ProductDto> findByPriceGreaterThan(Double minPrice);
    List<ProductDto> findByCategoryAndPriceGreaterThan(Integer categoryId, Double minPrice);
    List<ProductDto> findByNameContains(String keyword);
}
