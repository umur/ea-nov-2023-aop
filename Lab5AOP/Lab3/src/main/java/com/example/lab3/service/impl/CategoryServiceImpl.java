package com.example.lab3.service.impl;

import com.example.lab3.Entity.Category;
import com.example.lab3.repository.CategoryRepository;
import com.example.lab3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category>getAllCategories(){
        return  categoryRepository.findAll();
    }

    @Override
    public Category findByName(String categoryName) {
        return null;
    }

    @Override
    public Category getCategoryById(int categoryId){
        Optional<Category> category=categoryRepository.findById(categoryId);
        return category.orElse(null);
    }


    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int categoryId,Category updateCategory){
        Optional<Category>existingCategory=categoryRepository.findById(categoryId);
        if(existingCategory.isPresent()){
            Category category =existingCategory.get();
            category.setName(updateCategory.getName());
            return categoryRepository.save(category);
        }
        else return  null;
    }

    @Override
    public boolean deleteCategory(int categoryId){
        if(categoryRepository.existsById(categoryId)){
            categoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
    }


}
