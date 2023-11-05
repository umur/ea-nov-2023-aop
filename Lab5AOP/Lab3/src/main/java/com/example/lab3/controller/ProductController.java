package com.example.lab3.controller;

import com.example.lab3.Entity.Category;
import com.example.lab3.Entity.Product;
import com.example.lab3.service.CategoryService;
import com.example.lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping("/by-price/{minPrice}")
    public List<Product> getProductsByMinPrice(@PathVariable double minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping("/by-category-and-price/{categoryName}/{maxPrice}")
    public List<Product> getProductsByCategoryAndMaxPrice(
            @PathVariable String categoryName,
            @PathVariable double maxPrice
    ) {
        Category category = categoryService.findByName(categoryName);

        return productService.getProductsByCategoryAndMaxPrice(category, maxPrice);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
