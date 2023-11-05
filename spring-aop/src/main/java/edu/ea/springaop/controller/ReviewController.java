package edu.ea.springaop.controller;


import edu.ea.springaop.dto.FullProductDto;
import edu.ea.springaop.dto.FullReviewDto;
import edu.ea.springaop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;





    @PutMapping("/{id}")
    FullReviewDto update (@PathVariable Integer id,@RequestBody FullReviewDto fullReviewDto) throws Exception {
        return reviewService.update(id,fullReviewDto);
    }

    @DeleteMapping("/{id}")
    Boolean delete (@PathVariable Integer id ) throws Exception {
        return reviewService.delete(id);
    }


}
