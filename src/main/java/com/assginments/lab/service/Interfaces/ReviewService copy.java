package com.assginments.lab.service.Interfaces;

import java.util.List;

import com.assginments.lab.dto.NewReviewDto;
import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.entity.Review;
import com.assginments.lab.service.Generic.GenericService;

public interface ReviewService extends GenericService<Review, ReviewDto, NewReviewDto> {
    // Find reviews of the product whose id is id.
    List<ReviewDto> findByProductIdEquals(int productId);

    List<ReviewDto> findByUserIdEquals(int userId);
}