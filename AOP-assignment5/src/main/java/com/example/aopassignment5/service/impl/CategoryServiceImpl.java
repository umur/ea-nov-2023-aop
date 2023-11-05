package com.example.aopassignment5.service.impl;

import com.example.aopassignment5.aspect.ExecutionTime;
import com.example.aopassignment5.model.Category;
import com.example.aopassignment5.repository.CategoryRepo;
import com.example.aopassignment5.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    @Override
    @ExecutionTime
    public Category findById(int id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    @ExecutionTime
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    @ExecutionTime
    public Category updateCategory(int id, Category category) {

        Category category1 = categoryRepo.findById(id).get();
        if (category != null) {
            category.setName(category1.getName());
            return categoryRepo.save(category);
        }
        return category1;
    }

    @Override
    @ExecutionTime
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
}
