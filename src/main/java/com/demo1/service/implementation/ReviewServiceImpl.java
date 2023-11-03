package com.demo1.service.implementation;


import com.demo1.domain.dto.ReviewDto;
import com.demo1.domain.entities.Review;
import com.demo1.repository.ReviewRepo;
import com.demo1.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepo reviewRepo;
    ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo, ModelMapper modelMapper){
        this.reviewRepo = reviewRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        List<ReviewDto>reviewDtoList = new ArrayList<>();
        reviewRepo.findAll().forEach(r->reviewDtoList.add(modelMapper.map(r, ReviewDto.class)));
        return reviewDtoList;
    }

    @Override
    public ReviewDto getReviewById(int id) {

        Review review = reviewRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found with id:" + id));
        return modelMapper.map(review, ReviewDto.class);
    }


    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        review.setId(-1);
        Review savedReview = reviewRepo.save(review);
        return modelMapper.map(savedReview, ReviewDto.class);
    }
    @Override
    public ReviewDto updateReview(int id, ReviewDto reviewDto) {
        if(!reviewRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found with id: + id");
        }
        Review review = modelMapper.map(reviewDto, Review.class);
        review.setId(-1);
        Review savedReview = reviewRepo.save(review);
        return modelMapper.map(savedReview, ReviewDto.class);
    }

    @Override
    public void deleteReview(int id) {
        if(!reviewRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found with id:" +id);
        }
        try {
            reviewRepo.deleteById(id);
        } catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @Override
    public List<ReviewDto> getReviewsByProductId(int id) {
        return null;
    }
}
