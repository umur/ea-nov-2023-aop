package com.miu.edu.student.bacha.lab3.controllers;

import com.miu.edu.student.bacha.lab3.models.Category;
import com.miu.edu.student.bacha.lab3.models.Product;
import com.miu.edu.student.bacha.lab3.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable int id){
        return categoryService.updateCategory(id, category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

}
