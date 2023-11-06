package com.demo1.controller;


import com.demo1.domain.dto.CategoryDto;
import com.demo1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public CategoryDto getById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public CategoryDto add(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable int id, @RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.deleteCategory(id);
    }
}
