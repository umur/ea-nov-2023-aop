package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;
import com.miu.edu.student.bacha.lab3.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).orElseThrow(()->new RuntimeException("""
                No product with id:${id} exists."""));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        if(productRepo.existsById(id)) {
            return productRepo.save(product);
        }
        throw new RuntimeException("""
                No product with id: ${id} exists""");
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getProducts(Category category, double maxPrice) {
        return productRepo.findByCategoryAndPriceLessThan(category, maxPrice);
    }

    @Override
    public List<Product> getProduct(double minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductContaining(String keyword) {
        return productRepo.findByNameContaining(keyword);
    }
}
