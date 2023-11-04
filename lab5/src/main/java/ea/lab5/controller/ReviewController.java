package ea.lab5.controller;

import ea.lab5.dto.ReviewDto;
import ea.lab5.entity.Review;
import ea.lab5.repository.ReviewRepository;
import ea.lab5.service.ReviewService;
import ea.lab5.service.impl.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewServiceImpl reviewService;
    @GetMapping("/byProduct/{productId}")
    public List<ReviewDto> findByProduct_Id(@PathVariable int productId){
        return reviewService.findReviewsByProductId(productId);
    }

}
