package com.miu.edu.student.bacha.lab3.controllers;

import com.miu.edu.student.bacha.lab3.models.Review;
import com.miu.edu.student.bacha.lab3.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id){
        return reviewService.getReviewById(id);
    }
    @PostMapping
    public Review addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }
    @PutMapping("{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review){
        return reviewService.updateReview(id, review);
    }
    @DeleteMapping
    public void deleteReviewById(@PathVariable int id){
        reviewService.deleteReview(id);
    }
}
