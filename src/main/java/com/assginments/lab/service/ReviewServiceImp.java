package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assginments.lab.dto.NewReviewDto;
import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.entity.Review;
import com.assginments.lab.repository.ReviewRepo;
import com.assginments.lab.service.Generic.GenericServiceImp;
import com.assginments.lab.service.Interfaces.ReviewService;

import jakarta.transaction.Transactional;

@Service
public class ReviewServiceImp extends GenericServiceImp<Review, ReviewDto, NewReviewDto, ReviewRepo>
        implements ReviewService {
    private ReviewRepo reviewRepo;
    private ModelMapper mapper;

    @Autowired
    public ReviewServiceImp(ReviewRepo repo, ModelMapper mapper) {
        super(repo, mapper);
        this.reviewRepo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<ReviewDto> findByProductIdEquals(int productId) {
        var reviews = reviewRepo.findByProductId(productId);

        List<ReviewDto> result = mapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());
        return result;
    }

    @Override
    public List<ReviewDto> findByUserIdEquals(int userId) {
        var reviews = reviewRepo.findByUserId(userId);

        List<ReviewDto> result = mapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());
        return result;
    }

    @Override
    public Class<ReviewDto> getTDtoClass() {
        return ReviewDto.class;
    }

    @Override
    public Class<Review> getTEntityClass() {
        return Review.class;
    }

    @Override
    public Class<NewReviewDto> getTNewEntityDtoClass() {
        return NewReviewDto.class;
    }

    @Override
    @Transactional
    public void update(int id, NewReviewDto updatedDto) {
        reviewRepo.findById(id).ifPresent(x -> {
            x.setComment(updatedDto.getComment());
        });
    }

}