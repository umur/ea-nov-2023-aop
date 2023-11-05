package com.miu.lab4aop.repository;

import com.miu.lab4aop.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProductId(@NonNull Integer productId);
}