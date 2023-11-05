package com.example.aopassignment5.service;

import com.example.aopassignment5.model.Review;

import java.util.List;

public interface ReviewService {
    Review findById(int id);
    Review saveReview(Review review);
    Review updateReview(int id,Review review);
    void deleteReview(int id);
    List<Review> findAllByProductId(int id);
}