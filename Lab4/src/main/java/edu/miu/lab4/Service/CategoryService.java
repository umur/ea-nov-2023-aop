package edu.miu.lab4.Service;


import edu.miu.lab4.Model.Category;

public interface CategoryService {
    Category findById(int id);
    Category saveCategory(Category category);
    Category updateCategory(int id,Category category);
    void deleteCategory(int id);
}
