package com.example.demo.service.impl;

import com.example.demo.aspect.ExecutionTime;
import com.example.demo.aspect.LogMe;
import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;


    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<ReviewDto> getReviewsByProduct(Long productId) {
        List<Review> reviews =  reviewRepository.findByProduct_Id(productId);
        var result = new ArrayList<ReviewDto>();

        reviews.forEach(review -> {
            var reviewDto = modelMapper.map(review, ReviewDto.class);
            result.add(reviewDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<ReviewDto> getAllReviews() {

        List<Review> reviews =  reviewRepository.findAll();
        var result = new ArrayList<ReviewDto>();

        reviews.forEach(review -> {
            var reviewDto = modelMapper.map(review, ReviewDto.class);
            result.add(reviewDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public ReviewDto getReviewById(long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return modelMapper.map(reviewOptional.orElse(null), ReviewDto.class);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void updateReview(long id, Review updatedReview) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review existingReview = reviewOptional.get();
            // Update user properties with values from updatedUser
            existingReview.setComment(updatedReview.getComment());
            existingReview.setUser(updatedReview.getUser());
            existingReview.setProduct(updatedReview.getProduct());

            reviewRepository.save(existingReview);
        }
    }

    @ExecutionTime
    @LogMe
    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }
}
