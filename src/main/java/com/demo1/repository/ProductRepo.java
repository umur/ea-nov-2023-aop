package com.demo1.repository;


import com.demo1.domain.entities.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepo extends ListCrudRepository<Product, Integer> {
}
