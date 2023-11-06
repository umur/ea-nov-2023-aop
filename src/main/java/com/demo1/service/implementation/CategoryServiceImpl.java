package com.demo1.service.implementation;


import com.demo1.domain.dto.CategoryDto;
import com.demo1.domain.entities.Category;
import com.demo1.repository.CategoryRepo;
import com.demo1.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepo categoryRepo;
    ModelMapper modelMapper;

    @Autowired
    public  CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper){
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryRepo.findAll().forEach(c ->categoryDtoList.add(modelMapper.map(c, CategoryDto.class)));
        return categoryDtoList;
    }

    @Override
    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id" + id));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setId(-1);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(int id, CategoryDto categoryDto) {
        if(!categoryRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id" + id);
        }
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setId(-1);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(int id) {
        if (!categoryRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id: " + id);
        }

        try {
            categoryRepo.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
