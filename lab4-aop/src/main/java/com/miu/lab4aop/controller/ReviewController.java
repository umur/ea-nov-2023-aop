package com.miu.lab4aop.controller;

import com.miu.lab4aop.aspects.annotations.ExecutionTime;
import com.miu.lab4aop.dto.ReviewDto;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/reviews")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable("id") Integer id) {
        ReviewDto review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(reviewService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<ReviewDto>> pageQuery() {
        List<ReviewDto> reviewPage = reviewService.findAll();
        return ResponseEntity.ok(reviewPage);
    }

    @GetMapping("/searchBy/{productId}")
    public ResponseEntity<List<ReviewDto>> searchByProductId(@PathVariable("productId") Integer productId) {
        List<ReviewDto> reviewPage = reviewService.findByProductId(productId);
        return ResponseEntity.ok(reviewPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> update(@RequestBody @Validated ReviewDto reviewDto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(reviewService.update(reviewDto, id));
    }
}
