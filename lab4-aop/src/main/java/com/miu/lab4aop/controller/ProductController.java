package com.miu.lab4aop.controller;

import com.miu.lab4aop.dto.ProductDto;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ProductDto productDto) {
        productService.save(productDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Integer id) {
        ProductDto product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(productService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> pageQuery() {
        List<ProductDto> productPage = productService.findAll();
        return ResponseEntity.ok(productPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@RequestBody @Validated ProductDto productDto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.update(productDto, id));
    }

    @GetMapping("/searchBy")
    public ResponseEntity<List<ProductDto>> findByPriceGreaterThan(@RequestParam(value = "minPrice", required = false) Double minPrice,
                                                                   @RequestParam(value = "category", required = false) Integer categoryId) {
        List<ProductDto> productPage = null;
        if (categoryId != null) {
            productPage = productService.findByCategoryAndPriceGreaterThan(categoryId, minPrice);
        }
        productPage = productService.findByPriceGreaterThan(minPrice);
        return ResponseEntity.ok(productPage);
    }
    @GetMapping("/searchByName/{keyword}")
    public ResponseEntity<List<ProductDto>> findByNameContains(@PathVariable("keyword") String keyword) {
        List<ProductDto> productPage = productService.findByNameContains(keyword);
        return ResponseEntity.ok(productPage);
    }
}
