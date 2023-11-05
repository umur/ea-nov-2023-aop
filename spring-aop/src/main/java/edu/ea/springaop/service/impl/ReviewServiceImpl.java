package edu.ea.springaop.service.impl;


import edu.ea.springaop.dto.FullProductDto;
import edu.ea.springaop.dto.FullReviewDto;

import edu.ea.springaop.dto.FullUserDto;
import edu.ea.springaop.dto.UserInfoDto;
import edu.ea.springaop.model.Product;
import edu.ea.springaop.model.Review;
import edu.ea.springaop.repository.ProductRepo;
import edu.ea.springaop.repository.ReviewRepo;
import edu.ea.springaop.repository.UserRepo;
import edu.ea.springaop.service.ProductService;
import edu.ea.springaop.service.ReviewService;
import edu.ea.springaop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {
    private  final ModelMapper modelMapper;
    private final ReviewRepo  reviewRepo;

    private final ProductService productService;

    private final UserService userService;

    @Override
    public List<FullReviewDto> findAllByProductId(Integer productId) throws Exception {
        FullProductDto product = productService.findById(productId);
        return  product.getReviews();
    }

    @Override
    public List<FullReviewDto> findAllByUserId(Integer userId) throws Exception {
        FullUserDto user = userService.findById(userId);
        return  user.getReviews();

    }

    @Override
    @Transactional
    public FullReviewDto update(Integer id, FullReviewDto fullReviewDto) throws Exception {
        Optional<Review> oldReview =  reviewRepo.findById(id);
        if(!oldReview.isPresent())
            throw  new Exception("Review not found");
        Review review =  modelMapper.map(fullReviewDto,Review.class);
        review.setId(id);
        return    modelMapper.map(reviewRepo.save(review),FullReviewDto.class);
    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        Optional<Review> oldReview =  reviewRepo.findById(id);
        if(!oldReview.isPresent())
            throw  new Exception("Review not found");

        Review review = oldReview.get();
        review.setDeleted(true);
        reviewRepo.save(review);
        return  true;
    }

    @Override
    @Transactional
    public FullReviewDto addReview(Integer productId,Integer userId,FullReviewDto fullReviewDto) throws Exception {
           FullProductDto fullProductDto=  productService.findById(productId);
          FullUserDto fullUserDto = userService.findById(userId);
          fullReviewDto.setUser(modelMapper.map(fullUserDto, UserInfoDto.class));
           Review savedReview = reviewRepo.save(modelMapper.map(fullReviewDto, Review.class));
           fullProductDto.getReviews().add(modelMapper.map(savedReview,FullReviewDto.class));
           productService.update(fullProductDto.getId(),fullProductDto);
        return modelMapper.map( savedReview, FullReviewDto.class);
    }
}
