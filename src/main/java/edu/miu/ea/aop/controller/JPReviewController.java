package edu.miu.ea.aop.controller;

import edu.miu.ea.aop.model.dto.JPReviewDTO;
import edu.miu.ea.aop.service.JPReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class JPReviewController {

    private JPReviewService service;

    @PutMapping("/{id}")
    JPReviewDTO update(@PathVariable Long id, @RequestBody JPReviewDTO reviewDTO) throws Exception {
        return service.update(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    Boolean retire(@PathVariable Long id) throws Exception {
        return service.retire(id);
    }

}
