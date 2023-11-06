package com.demo1.service;






import com.demo1.domain.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getAllReviews();

    ReviewDto getReviewById(int id);

    ReviewDto addReview(ReviewDto reviewDto);

    ReviewDto updateReview(int id, ReviewDto reviewDto);

    void deleteReview(int id);


    List<ReviewDto> getReviewsByProductId(int id);
}
