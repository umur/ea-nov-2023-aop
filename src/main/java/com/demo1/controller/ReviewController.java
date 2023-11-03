package com.demo1.controller;


import com.demo1.domain.dto.ReviewDto;
import com.demo1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

     ReviewService reviewService;

     @Autowired
     public ReviewController(ReviewService reviewService){
         this.reviewService = reviewService;
     }

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping()
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @PutMapping("/{id}")
    public ReviewDto update(@PathVariable int id, @RequestBody ReviewDto reviewDto) {
        return reviewService.updateReview(id, reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.deleteReview(id);
    }

    // Find reviews of the product whose id is id
    @GetMapping("/reviews/{id}")
    public List<ReviewDto> findByProductId(@PathVariable int id) {
        return reviewService.getReviewsByProductId(id);
    }
}
