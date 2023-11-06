package com.demo1.service;




import com.demo1.domain.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(int id);

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(int id, CategoryDto categoryDto);

    void deleteCategory(int id);

}
