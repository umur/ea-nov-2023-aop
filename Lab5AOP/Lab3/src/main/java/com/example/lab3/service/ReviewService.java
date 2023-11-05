package com.example.lab3.service;

import com.example.lab3.Entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByProduct(Long productId);

    List<Review> getAllReviews();
    Review getReviewById(int reviewId);
    Review createReview(Review review);
    Review updateReview(int reviewid, Review updateReview);
    boolean deleteReview(int reviewId);
}
