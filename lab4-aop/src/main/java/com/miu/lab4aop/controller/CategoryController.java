package com.miu.lab4aop.controller;

import com.miu.lab4aop.dto.CategoryDto;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/categories")
@RestController
@Slf4j
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Integer id) {
        CategoryDto category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(categoryService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> pageQuery() {
        List<CategoryDto> categoryPage = categoryService.findAll();
        return ResponseEntity.ok(categoryPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@RequestBody @Validated CategoryDto categoryDto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoryService.update(categoryDto, id));
    }
}
