package com.example.lab3.service.impl;

import com.example.lab3.Entity.Review;
import com.example.lab3.repository.ReviewRepository;
import com.example.lab3.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProduct_Id(productId);
    }
    @Override
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
    @Override
    public Review getReviewById(int reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.orElse(null);
    }
    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    @Override
    public  Review updateReview(int reviewid, Review updateReview){
        Optional<Review>existingReview= reviewRepository.findById(reviewid);
        if (existingReview.isPresent()){
            Review review= existingReview.get();
            review.setComment(updateReview.getComment());
            return reviewRepository.save(review);
        }
        else return null;
    }

    @Override
    public boolean deleteReview(int reviewId){
        if (reviewRepository.existsById(reviewId)){
            reviewRepository.deleteById(reviewId);
            return  true;
        }
        else return false;
    }

}
