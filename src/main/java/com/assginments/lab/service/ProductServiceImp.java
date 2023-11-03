package com.assginments.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assginments.lab.dto.NewProductDto;
import com.assginments.lab.dto.ProductDto;
import com.assginments.lab.dto.ProductFilterDto;
import com.assginments.lab.entity.Product;
import com.assginments.lab.repository.ProductRepo;
import com.assginments.lab.service.Interfaces.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper mapper;

    // findAll
    public List<ProductDto> findAll() {
        var products = productRepo.findAll();
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

    // findById
    public ProductDto findById(int id) {
        if (!productRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return mapper.map(productRepo.findById(id), ProductDto.class);
    }

    // Add
    public void add(NewProductDto newProdcut) {
        var product = mapper.map(newProdcut, Product.class);
        productRepo.save(product);
    }

    // update
    public void update(int id, NewProductDto updatedProductDto) {
        var product = productRepo.findById(id);
        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        product.get().setName(updatedProductDto.getName());
        product.get().setPrice(updatedProductDto.getPrice());
        product.get().setRating(updatedProductDto.getRating());

        productRepo.save(product.get());

    }

    // remove
    public void remove(int id) {
        if (!productRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        productRepo.deleteById(id);
    }

    @Override
    public List<ProductDto> findByPriceMoreThan(double minPrice) {
        var products = productRepo.findByPriceGreaterThan(minPrice);
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;

    }

    @Override
    public List<ProductDto> findByCategoryIdAndPriceLessThan(int categoryId, double maxPrice) {
        var products = productRepo.findByCategoryIdAndPriceLessThan(categoryId, maxPrice);
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

    @Override
    public List<ProductDto> findByNameContaining(String keyword) {
        var products = productRepo.findByNameContaining(keyword);
        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

    @Override
    public List<ProductDto> filterBy(ProductFilterDto productFilterDto) {
        List<Product> products = new ArrayList<>();
        var productsIterable = productRepo.findAll();

        for (Product p : productsIterable) {
            products.add(p);
        }

        if (StringUtils.isNotBlank(productFilterDto.getName()) && StringUtils.isNotEmpty(productFilterDto.getName())) {
            products = products.stream().filter(x -> x.getName().startsWith(productFilterDto.getName())).toList();
        }
        if (productFilterDto.getCategoryId() > 0) {
            products = products.stream().filter(x -> x.getCategory().getId() == productFilterDto.getCategoryId())
                    .toList();
        }
        if (productFilterDto.getMinPrice() > 0) {
            products = products.stream().filter(x -> x.getPrice() > productFilterDto.getMinPrice())
                    .toList();
        }

        List<ProductDto> result = mapper.map(products, new TypeToken<List<ProductDto>>() {
        }.getType());
        return result;
    }

}
