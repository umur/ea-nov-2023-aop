package com.miu.edu.student.bacha.lab3.services;


import com.miu.edu.student.bacha.lab3.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(int id);
    Review addReview(Review review);
    Review updateReview(int id, Review review);
    void deleteReview(int id);
    List<Review> getAllReviewsByProductId(int productId);
}
