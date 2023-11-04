package ea.lab5.service;

import ea.lab5.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findReviewsByProductId(int productId);
}
