package com.assginments.lab.service.Interfaces;

import java.util.List;

import com.assginments.lab.dto.NewProductDto;
import com.assginments.lab.dto.ProductDto;
import com.assginments.lab.dto.ProductFilterDto;

public interface ProductService {
    // findAll
    List<ProductDto> findAll();

    // findById
    ProductDto findById(int id);

    // Add
    void add(NewProductDto newProduct);

    // update
    void update(int id, NewProductDto updatedProductDto);

    // remove
    void remove(int id);

    // Find all products that cost more than minPrice.
    List<ProductDto> findByPriceMoreThan(double minPrice);

    // Find all products in cat category and cost less than maxPrice.
    List<ProductDto> findByCategoryIdAndPriceLessThan(int categoryId, double maxPrice);

    // Find all products that contain keyword in the name.
    List<ProductDto> findByNameContaining(String keyword);

    List<ProductDto> filterBy(ProductFilterDto productFilterDto);
}
