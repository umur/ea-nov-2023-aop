package edu.ea.springaop.service;


import edu.ea.springaop.dto.FullReviewDto;

import java.util.List;

public interface ReviewService {


     List<FullReviewDto> findAllByProductId(Integer productId) throws Exception;
    List<FullReviewDto> findAllByUserId(Integer userId) throws Exception;
    FullReviewDto update(Integer id, FullReviewDto fullReviewDto) throws Exception;
    boolean delete(Integer id) throws Exception;
    FullReviewDto addReview(Integer productId,Integer userId,FullReviewDto fullReviewDto) throws Exception;
}
