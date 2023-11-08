package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category addCategory(Category category);
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);

}
