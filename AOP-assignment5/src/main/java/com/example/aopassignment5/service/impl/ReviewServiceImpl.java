package com.example.aopassignment5.service.impl;

import com.example.aopassignment5.model.Review;
import com.example.aopassignment5.repository.ReviewRepo;
import com.example.aopassignment5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private  final ReviewRepo reviewRepo;
    @Override
    public Review findById(int id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview(int id, Review review) {


        Review review1 = reviewRepo.findById(id).get();
        if (review1 != null) {
            review1.setComment(review.getComment());
            return reviewRepo.save(review1);
        }
        return review1;
    }

    @Override
    public void deleteReview(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<Review> findAllByProductId(int id) {
        return reviewRepo.findAllByProduct_Id(id);
    }
}
