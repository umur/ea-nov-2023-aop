package com.miu.lab4aop.service;

import com.miu.lab4aop.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    void deleteById(Integer id);

    CategoryDto findById(Integer id);

    List<CategoryDto> findAll();

    CategoryDto update(CategoryDto categoryDto, Integer id);
}
