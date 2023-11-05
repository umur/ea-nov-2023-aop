package edu.ea.springaop.service.impl;

import edu.ea.springaop.dto.FullCategoryDto;

import edu.ea.springaop.model.Category;
import edu.ea.springaop.repository.CategoryRepo;
import edu.ea.springaop.repository.ProductRepo;
import edu.ea.springaop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl  implements CategoryService {
      private final CategoryRepo categoryRepo ;
      private  final ModelMapper modelMapper;



    @Override
    public List<FullCategoryDto> findAll() {
        return categoryRepo.findAll().stream().map(c ->  modelMapper.map(c,FullCategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public FullCategoryDto findById(Integer id) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(!optionalCategory.isPresent())
            throw  new Exception("Category not found");
        Category category = optionalCategory.get();

        return  modelMapper.map(category,FullCategoryDto.class);
    }

    @Override
    @Transactional
    public FullCategoryDto add(FullCategoryDto categoryDto) {
        return   modelMapper.map(categoryRepo.save(modelMapper.map(categoryDto,Category.class)),FullCategoryDto.class);

    }

    @Override
    @Transactional
    public FullCategoryDto update(Integer id,FullCategoryDto categoryDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(!optionalCategory.isPresent())
            throw  new Exception("Category not found");
        categoryDto.setId(id);
        return   modelMapper.map(categoryRepo.save(modelMapper.map(categoryDto,Category.class)),FullCategoryDto.class);
    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(!optionalCategory.isPresent())
            throw  new Exception("Category not found");
        Category category = optionalCategory.get();
        category.setDeleted(true);
        categoryRepo.save(category);
        return   true;
    }
}
