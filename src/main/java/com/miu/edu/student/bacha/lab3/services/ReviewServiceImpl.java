package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.Review;
import com.miu.edu.student.bacha.lab3.repositories.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepo.findById(id).orElseThrow(()->new RuntimeException("""
                No review with id: ${id} exists."""));
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview(int id, Review review) {
        if(reviewRepo.existsById(id)){
            review.setId(id);
            return reviewRepo.save(review);
        }
       throw new RuntimeException("""
               No review with id: 4{id} exists.""");
    }

    @Override
    public void deleteReview(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<Review> getAllReviewsByProductId(int productId) {
        return reviewRepo.findByProductId(productId);
    }
}
