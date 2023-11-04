package com.example.demo.service.impl;

import com.example.demo.aspect.ExecutionTime;
import com.example.demo.aspect.LogMe;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<ProductDto> getProductsByMinPrice(double minPrice) {
        List<Product> products =  productRepository.findByPriceGreaterThan(minPrice);
        var result = new ArrayList<ProductDto>();

        products.forEach(product -> {
            var productDto = modelMapper.map(product, ProductDto.class);
            result.add(productDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<ProductDto> getProductsByKeyword(String keyWord) {
        List<Product> products =  productRepository.findByNameContaining(keyWord);
        var result = new ArrayList<ProductDto>();

        products.forEach(product -> {
            var productDto = modelMapper.map(product, ProductDto.class);
            result.add(productDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<ProductDto> getProductsByCategoryAndMaxPrice(CategoryDto category, double maxPrice) {
        List<Product> products =  productRepository.findByCategoryAndPriceLessThan(category, maxPrice);
        var result = new ArrayList<ProductDto>();

        products.forEach(product -> {
            var productDto = modelMapper.map(product, ProductDto.class);
            result.add(productDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<ProductDto> getAllProducts() {
        List <Product> products = productRepository.findAll();
        var result = new ArrayList<ProductDto>();

        products.forEach(product -> {
            var productDto = modelMapper.map(product, ProductDto.class);
            result.add(productDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public ProductDto getProductById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return modelMapper.map(productOptional.orElse(null), ProductDto.class);
    }

    @ExecutionTime
    @LogMe
    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @ExecutionTime
    @LogMe
    @Override
    public void updateProduct(long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            // Update user properties with values from updatedUser
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setRating(updatedProduct.getRating());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setReviews(updatedProduct.getReviews());

            productRepository.save(existingProduct);
        }
    }

    @ExecutionTime
    @LogMe
    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }


}
