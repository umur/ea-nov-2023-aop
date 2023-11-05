package com.miu.lab4aop.service.impl;

import com.miu.lab4aop.common.Converter;
import com.miu.lab4aop.dto.CategoryDto;
import com.miu.lab4aop.entity.Category;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.repository.CategoryRepository;
import com.miu.lab4aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final Converter converter;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category entity = converter.convert(categoryDto, Category.class);
        return converter.convert(repository.save(entity), CategoryDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> entities = repository.findAll();
        return converter.convertList(entities, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Integer id) {
        Optional<Category> data = repository.findById(id);
        Category updatedEntity = data.map(entity -> converter.convert(categoryDto, Category.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, CategoryDto.class));
    }
}
