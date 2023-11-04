package com.example.demo.service;


import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ReviewService {
    ArrayList<ReviewDto> getReviewsByProduct(Long productId);
    public ArrayList<ReviewDto> getAllReviews();

    public ReviewDto getReviewById(long id);

    public void createReview(Review review);

    public void updateReview(long id, Review updatedReview);

    public void deleteReview(long id);
}
