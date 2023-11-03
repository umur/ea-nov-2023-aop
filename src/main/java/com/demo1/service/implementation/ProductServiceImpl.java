package com.demo1.service.implementation;

import com.demo1.domain.dto.ProductDto;
import com.demo1.domain.entities.Product;
import com.demo1.repository.ProductRepo;
import com.demo1.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {

    ProductRepo productRepo;
    ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ModelMapper modelMapper){
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepo.findAll().forEach(p -> productDtoList.add(modelMapper.map(p, ProductDto.class)));
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id:" + id));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.setId(-1);
        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        if(!productRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id:" + id);
        }
         Product product = modelMapper.map(productDto, Product.class);
         product.setId(-1);
         Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }


    @Override
    public void deleteProduct(int id) {
        if(!productRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id" + id);
        }
        try {
            productRepo.deleteById(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @Override
    public List<ProductDto> getProductsByMinPrice(int minPrice) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategoryIdAndMaxPrice(int id, int maxPrice) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByKeyword(String keyword) {
        return null;
    }
}
