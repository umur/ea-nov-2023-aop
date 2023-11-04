package com.example.demo.service.impl;

import com.example.demo.aspect.ExecutionTime;
import com.example.demo.aspect.LogMe;
import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @LogMe
    @Override
    public CategoryDto findByName(String categoryName) {
        return modelMapper.map(categoryRepository.findByName(categoryName), CategoryDto.class);
    }


    @ExecutionTime
    @LogMe
    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categoryList =  categoryRepository.findAll();
        var result = new ArrayList<CategoryDto>();

        categoryList.forEach(category -> {
            var categoryDto = modelMapper.map(category, CategoryDto.class);
            result.add(categoryDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public CategoryDto getCategoryById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return modelMapper.map(categoryOptional.orElse(null), CategoryDto.class);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void updateCategory(long id, Category updatedCategory) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();
            // Update user properties with values from updatedUser
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setProducts(updatedCategory.getProducts());
            categoryRepository.save(existingCategory);
        }
    }

    @ExecutionTime
    @LogMe
    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }


}

