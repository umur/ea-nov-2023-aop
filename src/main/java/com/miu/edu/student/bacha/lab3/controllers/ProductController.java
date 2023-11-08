package com.miu.edu.student.bacha.lab3.controllers;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;
import com.miu.edu.student.bacha.lab3.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PutMapping("{id}")
    private Product updateProduct(@PathVariable int id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @GetMapping("/category/{categoryId}/maxPrice/{maxPrice}")
    public List<Product> getProductsByCategoryAndPriceLessThan(@PathVariable int categoryId, @PathVariable double maxPrice) {
        Category category = new Category();
        category.setId(categoryId);
        return productService.getProducts(category, maxPrice);
    }

    @GetMapping("/minPrice/{minPrice}")
    public List<Product> getProductsByPriceGreaterThan(@PathVariable double minPrice) {
        return productService.getProduct(minPrice);
    }

    @GetMapping("/keyword")
    public List<Product> getProductsByNameContaining(@RequestParam String keyword) {
        return productService.getProductContaining(keyword);
    }

}
