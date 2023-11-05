package edu.ea.springaop.controller;


import edu.ea.springaop.dto.FullProductDto;
import edu.ea.springaop.dto.FullReviewDto;
import edu.ea.springaop.service.ProductService;
import edu.ea.springaop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;
  private  final ReviewService reviewService;
     @GetMapping
    List<FullProductDto> findAll()
     {
         return productService.findAll();
     }

    @GetMapping("/search")
    FullProductDto findById(@RequestParam  Integer id) throws Exception {
        return productService.findById(id);
    }

    @GetMapping("/{productId}/reviews")
    List<FullReviewDto> findProductReviews(@PathVariable  Integer productId) throws Exception {
        return reviewService.findAllByProductId(productId);
    }


    @PostMapping("/{productId}/{userId}/reviews")
    FullReviewDto addReview (@PathVariable  Integer productId, @PathVariable  Integer userId,@RequestBody  FullReviewDto fullReviewDto) throws Exception {
        return reviewService.addReview(productId,userId,fullReviewDto);
    }

    @PostMapping
    FullProductDto add ( @RequestBody  FullProductDto fullProductDto) throws Exception {
        return productService.add(fullProductDto);
    }


    @PutMapping("/{id}")
    FullProductDto update (@PathVariable Integer id,@RequestBody  FullProductDto fullProductDto) throws Exception {
        return productService.update(id,fullProductDto);
    }

    @DeleteMapping("/{id}")
    Boolean delete (@PathVariable Integer id ) throws Exception {
        return productService.delete(id);
    }




}
