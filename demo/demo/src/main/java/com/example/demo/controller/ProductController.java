package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private  final ProductService productService;
    private  final CategoryService categoryService;

    // Implement CRUD operations for Product
    @GetMapping("/by-price/{minPrice}")
    public ArrayList<ProductDto> getProductsByMinPrice(@PathVariable double minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping("/by-category-and-price/{categoryName}/{maxPrice}")
    public ArrayList<ProductDto> getProductsByCategoryAndMaxPrice(
            @PathVariable String categoryName,
            @PathVariable double maxPrice
    ) {
        // Retrieve the Category entity based on the categoryName, e.g., by calling a service method
        CategoryDto category = categoryService.findByName(categoryName);

        // Use the category to filter products
        return productService.getProductsByCategoryAndMaxPrice(category, maxPrice);
    }

    @GetMapping("/by-keyword/{keyword}")
    public ArrayList<ProductDto> getProductsByKeyword(@PathVariable String keyword) {
        return productService.getProductsByKeyword(keyword);
    }


    @GetMapping
    public ArrayList<ProductDto> getAllUProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}