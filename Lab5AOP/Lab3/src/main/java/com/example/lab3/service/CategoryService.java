package com.example.lab3.service;

import com.example.lab3.Entity.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(int categoryId);
    Category createCategory(Category category);
    Category updateCategory(int categoryId,Category updateCategory);
    boolean deleteCategory(int categoryId);
    List<Category> getAllCategories();

    Category findByName(String categoryName);
}
