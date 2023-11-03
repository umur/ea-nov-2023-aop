package com.assginments.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.assginments.lab.dto.NewProductDto;
import com.assginments.lab.dto.ProductDto;
import com.assginments.lab.dto.ProductFilterDto;
import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.service.Interfaces.ProductService;
import com.assginments.lab.service.Interfaces.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prodcuts")
public class ProductController {
    private final ProductService productService;
    private final ReviewService reviewService;

    // findAll
    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    // findById
    @GetMapping("{id}")
    public ProductDto findByid(@PathVariable int id) {
        return productService.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody NewProductDto productDto) {
        productService.add(productDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody NewProductDto productDto) {
        productService.update(id, productDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        productService.remove(id);
    }

    // Find all products that cost more than minPrice.
    @GetMapping("filter-by-price")
    List<ProductDto> MoreThan(@RequestParam double minPrice) {
        return productService.findByPriceMoreThan(minPrice);
    }

    // Find all products in cat product and cost less than maxPrice.
    @GetMapping("filter-by-categoryId-price")
    List<ProductDto> findByCategoryIdAndLessThan(@RequestParam int categoryId, @RequestParam double maxPrice) {
        return productService.findByCategoryIdAndPriceLessThan(categoryId, maxPrice);
    }

    // Find all products that contain keyword in the name.
    @GetMapping("filter-by-name")
    List<ProductDto> findByNameContaining(@RequestParam String name) {
        return productService.findByNameContaining(name);
    }

    @GetMapping("/filter")
    public List<ProductDto> filter(ProductFilterDto productFilterDto) {
        return productService.filterBy(productFilterDto);
    }

    // Find All Product's Reviews
    @GetMapping("/{productId}/reviews")
    public List<ReviewDto> findAllProductReviews(@PathVariable int productId) {
        return reviewService.findByProductIdEquals(productId);
    }

}
