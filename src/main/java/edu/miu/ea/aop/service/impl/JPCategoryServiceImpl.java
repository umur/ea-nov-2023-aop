package edu.miu.ea.aop.service.impl;

import edu.miu.ea.aop.model.domain.JPCategory;
import edu.miu.ea.aop.model.dto.JPCategoryDTO;

import edu.miu.ea.aop.repository.JPCategoryRepository;
import edu.miu.ea.aop.service.JPCategoryService;
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
public class JPCategoryServiceImpl implements JPCategoryService {

    private final ModelMapper modelMapper;

    private final JPCategoryRepository repository;

    @Override
    @Transactional
    public JPCategoryDTO add(JPCategoryDTO categoryDto) {

        return modelMapper.map(repository.save(modelMapper.map(categoryDto, JPCategory.class)), JPCategoryDTO.class);

    }

    @Override
    @Transactional
    public JPCategoryDTO update(Long id, JPCategoryDTO categoryDto) throws Exception {

        Optional<JPCategory> optionalCategory = repository.findById(id);

        if (!optionalCategory.isPresent()) {
            throw new Exception("JPCategory doesn't exist");
        }

        categoryDto.setId(id);

        return modelMapper.map(repository.save(modelMapper.map(categoryDto, JPCategory.class)), JPCategoryDTO.class);

    }

    @Override
    public List<JPCategoryDTO> findAll() {

        return repository.findAll().stream().map(c -> modelMapper.map(c, JPCategoryDTO.class)).collect(Collectors.toList());

    }

    @Override
    public JPCategoryDTO findById(Long id) throws Exception {

        Optional<JPCategory> optionalCategory = repository.findById(id);

        if (!optionalCategory.isPresent()) {
            throw new Exception("JPCategory doesn't exist");
        }

        JPCategory category = optionalCategory.get();

        return modelMapper.map(category, JPCategoryDTO.class);

    }

    @Override
    @Transactional
    public boolean retire(Long id) throws Exception {

        Optional<JPCategory> optionalCategory = repository.findById(id);

        if (!optionalCategory.isPresent()) {
            throw new Exception("JPCategory doesn't exist");
        }

        JPCategory category = optionalCategory.get();
        category.setRetired(true);
        repository.save(category);

        return true;

    }

}
