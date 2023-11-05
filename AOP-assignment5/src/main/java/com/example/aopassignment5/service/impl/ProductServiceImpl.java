package com.example.aopassignment5.service.impl;

import com.example.aopassignment5.model.Category;
import com.example.aopassignment5.model.Product;
import com.example.aopassignment5.repository.ProductRepo;
import com.example.aopassignment5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public Product findById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product product1 = productRepo.findById(id).get();
        if (product1 != null) {
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setRating(product.getRating());
            productRepo.save(product1);
        }

        return null;
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getProductsMoreThan(double minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(Category category, double price) {
        return productRepo.findAllByCategoryAndPriceLessThan(category,price);
    }

    @Override
    public List<Product> getExistingContainsName(String keyword) {
        return productRepo.findAllByNameContains(keyword);
    }
}