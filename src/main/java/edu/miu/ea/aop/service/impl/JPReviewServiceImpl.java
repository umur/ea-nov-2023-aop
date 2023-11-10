package edu.miu.ea.aop.service.impl;

import edu.miu.ea.aop.model.dto.JPProductDTO;
import edu.miu.ea.aop.model.dto.JPReviewDTO;

import edu.miu.ea.aop.model.dto.JPUserDTO;
import edu.miu.ea.aop.model.dto.JPUserBasicDTO;
import edu.miu.ea.aop.model.domain.JPReview;
import edu.miu.ea.aop.repository.JPReviewRepository;
import edu.miu.ea.aop.service.JPProductService;
import edu.miu.ea.aop.service.JPReviewService;
import edu.miu.ea.aop.service.JPUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JPReviewServiceImpl implements JPReviewService {

    private final ModelMapper modelMapper;

    private final JPReviewRepository repository;

    private final JPUserService userService;
    private final JPProductService productService;

    @Override
    @Transactional
    public JPReviewDTO addReview(Long productId, Long userId, JPReviewDTO reviewDTO) throws Exception {

        JPProductDTO productDTO = productService.findById(productId);
        JPUserDTO userDTO = userService.findById(userId);

        reviewDTO.setUser(modelMapper.map(userDTO, JPUserBasicDTO.class));

        JPReview savedReview = repository.save(modelMapper.map(reviewDTO, JPReview.class));

        productDTO.getReviews().add(modelMapper.map(savedReview, JPReviewDTO.class));

        productService.update(productDTO.getId(), productDTO);

        return modelMapper.map(savedReview, JPReviewDTO.class);

    }

    @Override
    @Transactional
    public JPReviewDTO update(Long id, JPReviewDTO reviewDTO) throws Exception {

        Optional<JPReview> oldReview = repository.findById(id);

        if (!oldReview.isPresent()) {
            throw new Exception("JPReview doesn't exist");
        }

        JPReview review = modelMapper.map(reviewDTO, JPReview.class);
        review.setId(id);

        return modelMapper.map(repository.save(review), JPReviewDTO.class);

    }

    @Override
    public List<JPReviewDTO> findAllByProductId(Long productId) throws Exception {

        JPProductDTO product = productService.findById(productId);

        return product.getReviews();

    }

    @Override
    public List<JPReviewDTO> findAllByUserId(Long userId) throws Exception {

        JPUserDTO user = userService.findById(userId);

        return user.getReviews();

    }

    @Override
    @Transactional
    public boolean retire(Long id) throws Exception {

        Optional<JPReview> oldReview = repository.findById(id);

        if (!oldReview.isPresent()) {
            throw new Exception("JPReview doesn't exist");
        }

        JPReview review = oldReview.get();
        review.setRetired(true);
        repository.save(review);

        return true;

    }

}
