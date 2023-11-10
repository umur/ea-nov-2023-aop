package edu.miu.ea.aop.controller;

import edu.miu.ea.aop.model.dto.JPProductDTO;
import edu.miu.ea.aop.model.dto.JPReviewDTO;
import edu.miu.ea.aop.service.JPProductService;
import edu.miu.ea.aop.service.JPReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class JPProductController {

    private final JPProductService service;
    private final JPReviewService reviewService;

    @PostMapping("/{productId}/{userId}/reviews")
    JPReviewDTO addReview(@PathVariable Long productId, @PathVariable Long userId, @RequestBody JPReviewDTO reviewDTO) throws Exception {
        return reviewService.addReview(productId, userId, reviewDTO);
    }

    @PostMapping
    JPProductDTO add(@RequestBody JPProductDTO productDTO) throws Exception {
        return service.add(productDTO);
    }

    @PutMapping("/{id}")
    JPProductDTO update(@PathVariable Long id, @RequestBody JPProductDTO productDTO) throws Exception {
        return service.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    Boolean retire(@PathVariable Long id) throws Exception {
        return service.retire(id);
    }

    @GetMapping
    List<JPProductDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    JPProductDTO findById(@RequestParam Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/{productId}/reviews")
    List<JPReviewDTO> findProductReviews(@PathVariable Long productId) throws Exception {
        return reviewService.findAllByProductId(productId);
    }

}
