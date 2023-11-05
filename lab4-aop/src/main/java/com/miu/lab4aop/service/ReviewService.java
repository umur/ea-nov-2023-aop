package com.miu.lab4aop.service;

import com.miu.lab4aop.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto save(ReviewDto reviewDto);

    void deleteById(Integer id);

    ReviewDto findById(Integer id);

    List<ReviewDto> findAll();

    ReviewDto update(ReviewDto reviewDto, Integer id);

    List<ReviewDto> findByProductId(Integer productId);
}
