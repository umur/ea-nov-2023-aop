package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto findByName(String categoryName);

    public List<CategoryDto> getAllCategories();

    public CategoryDto getCategoryById(long id);
    public void createCategory(Category category);

    public void updateCategory(long id, Category category);

    public void deleteCategory(long id);
}
