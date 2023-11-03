package com.assginments.lab.service.Interfaces;

import java.util.List;

import com.assginments.lab.dto.CategoryDto;
import com.assginments.lab.dto.NewCategoryDto;

public interface CategoryService {
    // findAll
    List<CategoryDto> findAll();

    // findById
    CategoryDto findById(int id);

    // Add
    void add(NewCategoryDto newAddress);

    // update
    void update(int id, NewCategoryDto updatedCategoryDto);

    // remove
    void remove(int id);
}
