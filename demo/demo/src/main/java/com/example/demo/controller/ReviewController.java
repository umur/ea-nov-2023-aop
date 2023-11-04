package com.example.demo.controller;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // Implement CRUD operations for Review
    @GetMapping("/by-product/{productId}")
    public ArrayList<ReviewDto> getReviewsByProduct(@PathVariable Long productId) {
        return reviewService.getReviewsByProduct(productId);
    }

    @GetMapping
    public ArrayList<ReviewDto> getAllUsers() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ReviewDto getUserById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public void createUser(@RequestBody Review review) {
         reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}