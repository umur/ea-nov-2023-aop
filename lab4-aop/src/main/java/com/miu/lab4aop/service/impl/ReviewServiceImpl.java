package com.miu.lab4aop.service.impl;

import com.miu.lab4aop.common.Converter;
import com.miu.lab4aop.dto.ReviewDto;
import com.miu.lab4aop.entity.Review;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.repository.ReviewRepository;
import com.miu.lab4aop.service.ReviewService;
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
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final Converter converter;


    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review entity = converter.convert(reviewDto, Review.class);
        return converter.convert(repository.save(entity), ReviewDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ReviewDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), ReviewDto.class);
    }

    @Override
    public List<ReviewDto> findAll() {
        List<Review> entities = repository.findAll();
        return converter.convertList(entities, ReviewDto.class);
    }

    @Override
    public ReviewDto update(ReviewDto reviewDto, Integer id) {
        Optional<Review> data = repository.findById(id);
        Review updatedEntity = data.map(entity -> converter.convert(reviewDto, Review.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, ReviewDto.class));
    }

    @Override
    public List<ReviewDto> findByProductId(Integer productId) {
        return converter.convertList(repository.findAllByProductId(productId), ReviewDto.class);
    }
}
