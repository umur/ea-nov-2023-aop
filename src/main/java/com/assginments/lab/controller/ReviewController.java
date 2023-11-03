package com.assginments.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.assginments.lab.controller.Generic.GenericController;
import com.assginments.lab.dto.NewReviewDto;
import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.entity.Review;
import com.assginments.lab.service.Interfaces.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reviews")
public class ReviewController extends GenericController<Review, ReviewDto, NewReviewDto, ReviewService> {

    @Autowired
    public ReviewController(ReviewService service) {
        super(service);
    }

}
