package com.demo1.controller;


import com.demo1.domain.dto.ProductDto;
import com.demo1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

     ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDto> findAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping()
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable int id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/minPrice/{minPrice}")
    public List<ProductDto> findByMinPrice(@PathVariable int minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping("/category/{id}")
    public List<ProductDto> findByCategoryId(@PathVariable int id, @RequestParam int maxPrice) {
        return productService.getProductsByCategoryIdAndMaxPrice(id, maxPrice);
    }

    @GetMapping("/keyword")
    public List<ProductDto> findByKeyword(@RequestParam String keyword) {
        return productService.getProductsByKeyword(keyword);
    }
}
