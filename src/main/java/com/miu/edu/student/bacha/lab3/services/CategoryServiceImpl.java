package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;
import com.miu.edu.student.bacha.lab3.repositories.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("""
                No Category with id: ${id}"""));
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        if (categoryRepo.existsById(id)) {
            category.setId(id);
            return categoryRepo.save(category);
        }
        throw new RuntimeException("""
                No Category with id: ${id}""");
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }

}
