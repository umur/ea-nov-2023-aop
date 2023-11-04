package ea.lab5.service.impl;

import ea.lab5.aspect.ExecutionTime;
import ea.lab5.dto.ReviewDto;
import ea.lab5.entity.Review;
import ea.lab5.repository.ReviewRepository;
import ea.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<ReviewDto> findReviewsByProductId(int productId) {
        List<Review> reviewList = reviewRepository.findByProduct_Id(productId);
        List<ReviewDto> results = new ArrayList<>();

        for (Review review : reviewList) {
            ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
            results.add(reviewDto);
        }

        return results;
    }
}
